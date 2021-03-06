package shopApi.repositories.userRepository;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import shopApi.domain.LoginDTO;
import shopApi.domain.User;
import shopApi.domain.UserDTO;

import java.util.List;

public class UserRepositoryPostgreSql implements UserRepository {
    private final Sql2o sql2o;

    public UserRepositoryPostgreSql(String connection) {
        this.sql2o = sql2o(connection);
    }

    private Sql2o sql2o(String connectionUrl) {
        return new Sql2o(connectionUrl, "shoptheam", "alfred");
    }

    @Override
    public void save(UserDTO userDTO) {
        final String query = "INSERT INTO users(name, password, email, role, token)" +
                " VALUES (:name, :password, :email, :role, :token)";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("name", userDTO.getName())
                    .addParameter("password", userDTO.getPassword())
                    .addParameter("email", userDTO.getEmail())
                    .addParameter("role", userDTO.getRole())
                    .addParameter("token", userDTO.getToken()).executeUpdate();
        }
    }

    @Override
    public List<User> getAllUsers() {
        final String query = "SELECT * FROM users";
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(query).executeAndFetch(User.class);
        }
    }

    @Override
    public void deleteUser(int userId) {
        final String query = "DELETE FROM users WHERE id =" + userId;
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query).executeUpdate();
        }
    }

    @Override
    public void updateUser(int userId, UserDTO newUserDTO) {
        final String query = "UPDATE users SET name = :name, password = :password," +
                " email = :email, role = :role WHERE id =:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("name", newUserDTO.getName())
                    .addParameter("password", newUserDTO.getPassword())
                    .addParameter("email", newUserDTO.getEmail())
                    .addParameter("role", newUserDTO.getRole())
                    .addParameter("id", userId).executeUpdate();
        }
    }

    @Override
    public String verifySession(LoginDTO logDTO) {
        final String query = "SELECT * FROM users WHERE email = '" + logDTO.getEmail() +"'" +
                " AND password ='" + logDTO.getPassword() +"'";
        try (Connection connection = sql2o.open()) {
            User user = connection.createQuery(query).executeAndFetch(User.class).get(0);
            return user.getToken();
        }
    }

    @Override
    public User checkToken(String token) {
        final String query = "SELECT * FROM users WHERE token = '" + token +"'" ;
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(query).executeAndFetch(User.class).get(0);
        }
    }
}
