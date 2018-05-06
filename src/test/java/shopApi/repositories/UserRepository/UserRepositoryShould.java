package shopApi.repositories.UserRepository;

import com.google.common.hash.Hashing;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import shopApi.domains.User;
import shopApi.domains.UserDTO;
import shopApi.repositories.BaseRepositoryShould;
import shopApi.repositories.userRepository.UserRepositoryPostgreSql;

import java.nio.charset.StandardCharsets;
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
        userDTO = new UserDTO("user","user123","user@gmail.com","user");
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
        String hashPassword = HashPassword(userDTO);
        userDTO.setPassword(hashPassword);
        insertUser(userDTO);

        List<User> users = userRepository.getAllUsers();

        assertThat(userDTO.getName()).isEqualTo(users.get(0).getName());
        assertThat(userDTO.getPassword()).isEqualTo(users.get(0).getPassword());
        assertThat(userDTO.getEmail()).isEqualTo(users.get(0).getEmail());
        assertThat(userDTO.getRole()).isEqualTo(users.get(0).getRole());
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
            connection.createQuery("INSERT INTO users(name, email, password, role)" +
                    " VALUES (:name, :email, :password, :role)")
                    .addParameter("name", userDTO.getName())
                    .addParameter("email", userDTO.getEmail())
                    .addParameter("password", userDTO.getPassword())
                    .addParameter("role", userDTO.getRole()).executeUpdate();
        }
    }

    private String HashPassword(UserDTO userDTO) {
        return Hashing.sha256()
                .hashString(userDTO.getPassword(), StandardCharsets.UTF_8)
                .toString();
    }
}
