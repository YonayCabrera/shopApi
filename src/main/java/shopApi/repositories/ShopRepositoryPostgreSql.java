package shopApi.repositories;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import shopApi.domains.Customer;
import shopApi.domains.CustomerDTO;

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
    public void save(CustomerDTO customerDTO) {
        final String query = "INSERT INTO customers(name, surname, image)" +
                " VALUES (:name, :surname, :image)";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("name", customerDTO.getName())
                    .addParameter("surname", customerDTO.getSurname())
                    .addParameter("image", customerDTO.getImage()).executeUpdate();
        }
    }

    @Override
    public void remove(int customerId) {
        final String query = "DELETE FROM customers WHERE id ="+customerId;
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query).executeUpdate();
        }
    }

    @Override
    public void update(int customerId, CustomerDTO newCustomer) {
        final String query = "UPDATE customers SET name = :name, surname = :surname, image = :image WHERE id =:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("name", newCustomer.getName())
                    .addParameter("surname", newCustomer.getSurname())
                    .addParameter("image", newCustomer.getImage())
                    .addParameter("id", customerId).executeUpdate();
        }
    }

    @Override
    public Customer getCustomer(int customerId) {
        final String query = "SELECT * FROM customers WHERE id =" + customerId;
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(query).executeAndFetch(Customer.class).get(0);
        }
    }
}
