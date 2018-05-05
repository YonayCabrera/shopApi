package shopApi.repositories.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import shopApi.domains.User;
import shopApi.domains.UserDTO;
import shopApi.repositories.BaseRepositoryShould;
import shopApi.repositories.userRepository.UserRepositoryPostgreSql;

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
    private UserDTO customerDTO;

    @Before
    public void given_a_repository_and_a_database() {
        connection = new Sql2o(connectionTestDatabase, dbUser, dbPassword);
        userRepository = new UserRepositoryPostgreSql(connectionTestDatabase);
        customerDTO = new UserDTO("user","user123","user@gmail.com");
    }

    @Test
    public void save_one_user(){
        userRepository.save(customerDTO);

        User newUser = getAllUsers();

        assertThat(newUser.getName()).isEqualTo(customerDTO.getName());
        assertThat(newUser.getEmail()).isEqualTo(customerDTO.getEmail());
        assertThat(newUser.getPassword()).isEqualTo(customerDTO.getPassword());
    }

    private User getAllUsers(){
        try (Connection connection = this.connection.open()) {
            return connection.createQuery("Select * from users")
                    .executeAndFetch(User.class)
                    .get(0);
        }
    }
}
