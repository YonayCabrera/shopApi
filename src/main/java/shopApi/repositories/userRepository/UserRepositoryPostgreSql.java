package shopApi.repositories.userRepository;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import shopApi.domains.User;
import shopApi.domains.UserDTO;

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
        final String query = "INSERT INTO users(name, password, email, role)" +
                " VALUES (:name, :password, :email, :role)";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("name", userDTO.getName())
                    .addParameter("password", userDTO.getPassword())
                    .addParameter("email", userDTO.getEmail())
                    .addParameter("role", userDTO.getRole()).executeUpdate();
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

    }
}
