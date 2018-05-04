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
        final String query = "INSERT INTO customers(id,name, surname, image)" +
                " VALUES (:id, :name, :surname, :image)";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("id", customer.getId())
                    .addParameter("name", customer.getName())
                    .addParameter("surname", customer.getSurname())
                    .addParameter("image", customer.getImage()).executeUpdate();
        }
    }

    @Override
    public void remove(Customer customer) {
        final String query = "DELETE FROM customers WHERE id ="+customer.getId();
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query).executeUpdate();
        }
    }

    @Override
    public void update(int id, Customer newCustomer) {
        final String query = "UPDATE customers SET name = :name, surname = :surname, image = :image WHERE id =:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(query)
                    .addParameter("name", newCustomer.getName())
                    .addParameter("surname", newCustomer.getSurname())
                    .addParameter("image", newCustomer.getImage())
                    .addParameter("id", id).executeUpdate();
        }
    }
}
