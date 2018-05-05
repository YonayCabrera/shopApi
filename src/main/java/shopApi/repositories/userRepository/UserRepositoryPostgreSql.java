package shopApi.repositories.userRepository;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import shopApi.domains.UserDTO;

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
        final String query = "INSERT INTO users(name, password, email)" +
                " VALUES (:name, :password, :email)";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("name", userDTO.getName())
                    .addParameter("password", userDTO.getPassword())
                    .addParameter("email", userDTO.getEmail()).executeUpdate();
        }
    }
}
