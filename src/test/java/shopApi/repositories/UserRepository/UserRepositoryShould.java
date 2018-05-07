package shopApi.repositories.UserRepository;

import com.google.common.hash.Hashing;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import shopApi.domain.LoginDTO;
import shopApi.domain.User;
import shopApi.domain.UserDTO;
import shopApi.repositories.BaseRepositoryShould;
import shopApi.repositories.userRepository.UserRepositoryPostgreSql;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.codehaus.groovy.runtime.InvokerHelper.asList;

public class UserRepositoryShould extends BaseRepositoryShould {
    @Override
    protected List<String> deleteFromTables() {
        return asList("users");
    }

    private Sql2o connection;
    private UserRepositoryPostgreSql userRepository;
    private UserDTO userDTO;

    @Before
    public void given_a_repository_and_a_database() {
        connection = new Sql2o(connectionTestDatabase, dbUser, dbPassword);
        userRepository = new UserRepositoryPostgreSql(connectionTestDatabase);
        userDTO = new UserDTO(1,"user",
                "user123",
                "user@gmail.com",
                "user",
                "1234");
    }

    @Test
    public void save_one_user(){
        userRepository.save(userDTO);

        User newUser = getAllUsers();

        assertThat(newUser.getName()).isEqualTo(userDTO.getName());
        assertThat(newUser.getEmail()).isEqualTo(userDTO.getEmail());
        assertThat(newUser.getPassword()).isEqualTo(userDTO.getPassword());
    }

    @Test
    public void get_all_users(){
        String hashPassword = hashPassword(userDTO.getPassword());
        userDTO.setPassword(hashPassword);
        insertUser(userDTO);

        List<User> users = userRepository.getAllUsers();

        assertThat(userDTO.getName()).isEqualTo(users.get(0).getName());
        assertThat(userDTO.getPassword()).isEqualTo(users.get(0).getPassword());
        assertThat(userDTO.getEmail()).isEqualTo(users.get(0).getEmail());
        assertThat(userDTO.getRole()).isEqualTo(users.get(0).getRole());
    }

    @Test
    public void remove_one_user(){
        UserDTO otherUserDTO = new UserDTO(
                1,
                "otherUser",
                "user123",
                "otherUser@gmail.com",
                "user",
                "1234");
        insertUser(userDTO);
        insertUser(otherUserDTO);

        User newCustomer = getAllUsers();
        userRepository.deleteUser(newCustomer.getId());

        assertThat(otherUserDTO.getName()).isEqualTo(getAllUsers().getName());
        assertThat(otherUserDTO.getPassword()).isEqualTo(getAllUsers().getPassword());
        assertThat(otherUserDTO.getEmail()).isEqualTo(getAllUsers().getEmail());
        assertThat(otherUserDTO.getRole()).isEqualTo(getAllUsers().getRole());
    }

    @Test
    public void update_one_user(){
        insertUser(userDTO);
        UserDTO newUserDTO = new UserDTO(
                1,
                "otherUser",
                "user123",
                "otherUser@gmail.com",
                "user",
                "1234");
        int userId = getAllUsers().getId();
        String hashPassword = hashPassword(userDTO.getPassword());
        userDTO.setPassword(hashPassword);

        userRepository.updateUser(userId, newUserDTO);

        assertThat(newUserDTO.getName()).isEqualTo(getAllUsers().getName());
        assertThat(userId).isEqualTo(getAllUsers().getId());
        assertThat(newUserDTO.getEmail()).isEqualTo(getAllUsers().getEmail());
        assertThat(newUserDTO.getPassword()).isEqualTo(getAllUsers().getPassword());
        assertThat(newUserDTO.getRole()).isEqualTo(getAllUsers().getRole());
    }

    @Test
    public void return_key_when_user_log(){
        userDTO.setPassword(hashPassword(userDTO.getPassword()));
        insertUser(userDTO);
        LoginDTO loginDTO = new LoginDTO("user@gmail.com","user123");
        loginDTO.setPassword(hashPassword(loginDTO.getPassword()));

        String key = userRepository.verifySession(loginDTO);

        assertThat(userDTO.getToken()).isEqualTo(key);
    }

    @Test
    public void check_the_key(){
        userDTO.setPassword(hashPassword(userDTO.getPassword()));
        generateKey(userDTO);
        insertUser(userDTO);
        LoginDTO loginDTO = new LoginDTO("user@gmail.com","user123");
        loginDTO.setPassword(hashPassword(loginDTO.getPassword()));
        String key = getKey(loginDTO.getEmail(),loginDTO.getPassword());

        boolean goodKey = userRepository.checkToken(key);

        assertThat(goodKey).isEqualTo(true);
    }

    private User getAllUsers(){
        try (Connection connection = this.connection.open()) {
            return connection.createQuery("Select * from users")
                    .executeAndFetch(User.class)
                    .get(0);
        }
    }

    private void insertUser(UserDTO userDTO) {
        try (Connection connection = this.connection.open()) {
            connection.createQuery("INSERT INTO users(name, email, password, role, token)" +
                    " VALUES (:name, :email, :password, :role, :token)")
                    .addParameter("name", userDTO.getName())
                    .addParameter("email", userDTO.getEmail())
                    .addParameter("password", userDTO.getPassword())
                    .addParameter("role", userDTO.getRole())
                    .addParameter("token",userDTO.getToken()).executeUpdate();
        }
    }

    private String getKey(String email,String password){
        final String query = "SELECT * FROM users WHERE email = '" + email +"'" +
                " AND password ='" + password +"'";
        try (Connection connection = this.connection.open()) {
            User user = connection.createQuery(query).executeAndFetch(User.class).get(0);
            return user.getToken();
        }
    }

    private void generateKey(UserDTO userDTO){
        userDTO.setToken(hashPassword(String.valueOf(new Date().getTime())));
    }

    private String hashPassword(String password) {
        return Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
    }
}
