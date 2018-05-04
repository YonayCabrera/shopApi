package shopApi.repositories;

import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import shopApi.domains.Customer;

import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.codehaus.groovy.runtime.InvokerHelper.asList;

public class ShopRepositoryShould extends BaseRepositoryShould{
    @Override
    protected List<String> deleteFromTables() {
        return asList("customers");
    }

    private Sql2o connection;
    private ShopRepositoryPostgreSql shopRepository;
    private Customer customer;


    @Before
    public void given_a_repository_and_a_database() {
        connection = new Sql2o(connectionTestDatabase, dbUser, dbPassword);
        shopRepository = new ShopRepositoryPostgreSql(connectionTestDatabase);
        customer = new Customer(1,"yonay","cabrera","aaa");
    }

    @Test
    public void get_all_customers(){
        insertCustomer(customer);

        List<Customer>customers = shopRepository.getAllCustomers();

        assertThat(customer.getName()).isEqualTo(customers.get(0).getName());
    }

    @Test
    public void save_one_customer(){
        shopRepository.save(customer);

        Customer newCustomer = getAllCustomers();

        assertThat(newCustomer).isEqualTo(customer);
    }

    private void insertCustomer(Customer customer) {
        try (Connection connection = this.connection.open()) {
            connection.createQuery("INSERT INTO customers(id,name, surname, image)" +
                    " VALUES (:id, :name, :surname, :image)")
                    .addParameter("id", customer.getId())
                    .addParameter("name", customer.getName())
                    .addParameter("surname", customer.getSurname())
                    .addParameter("image", customer.getImage()).executeUpdate();
        }
    }

    private Customer getAllCustomers(){
        try (Connection connection = this.connection.open()) {
            return connection.createQuery("Select * from customers")
                    .executeAndFetch(Customer.class)
                    .get(0);
        }
    }
}

