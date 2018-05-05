package shopApi.repositories.userRepository;

import org.sql2o.Sql2o;
import shopApi.domains.User;

public class UserRepositoryPostgreSql implements UserRepository {
    private final Sql2o sql2o;

    public UserRepositoryPostgreSql(String connection) {
        this.sql2o = sql2o(connection);
    }

    private Sql2o sql2o(String connectionUrl) {
        return new Sql2o(connectionUrl, "shoptheam", "alfred");
    }

    @Override
    public void createUser(User user) {

    }
}
