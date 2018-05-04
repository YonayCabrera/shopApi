package shopApi.repositories;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import shopApi.domains.Customer;

import java.util.List;

public class ShopRepositoryPostgreSql implements ShopRepository {

    private final Sql2o sql2o;

    public ShopRepositoryPostgreSql(String connection) {
        this.sql2o = sql2o(connection);
    }

    private Sql2o sql2o(String connectionUrl) {
        return new Sql2o(connectionUrl, "shoptheam", "alfred");
    }

    @Override
    public List<Customer> getAllCustomers() {
        final String query = "SELECT * FROM customers";
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(query).executeAndFetch(Customer.class);
        }
    }

    @Override
    public void save(Customer customer) {

    }
}
