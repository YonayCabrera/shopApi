package shopApi.repositories;

import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import shopApi.domains.Customer;
import shopApi.domains.CustomerDTO;

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
    private CustomerDTO customerDTO;


    @Before
    public void given_a_repository_and_a_database() {
        connection = new Sql2o(connectionTestDatabase, dbUser, dbPassword);
        shopRepository = new ShopRepositoryPostgreSql(connectionTestDatabase);
        customerDTO = new CustomerDTO("yonay","cabrera","aaa");
    }

    @Test
    public void get_all_customers(){
        insertCustomer(customerDTO);

        List<Customer>customers = shopRepository.getAllCustomers();

        assertThat(customerDTO.getName()).isEqualTo(customers.get(0).getName());
    }

    @Test
    public void save_one_customer(){
        shopRepository.save(customerDTO);

        Customer newCustomer = getAllCustomers();

        assertThat(newCustomer.getName()).isEqualTo(customerDTO.getName());
        assertThat(newCustomer.getSurname()).isEqualTo(customerDTO.getSurname());
        assertThat(newCustomer.getImage()).isEqualTo(customerDTO.getImage());
    }

    @Test
    public void remove_one_customer(){
        CustomerDTO otherCustomer = new CustomerDTO(
                "jose",
                "déniz",
                "image.jpg");
        insertCustomer(customerDTO);
        insertCustomer(otherCustomer);

        Customer newCustomer = getAllCustomers();
        shopRepository.remove(newCustomer.getId());

        assertThat(otherCustomer.getName()).isEqualTo(getAllCustomers().getName());
        assertThat(otherCustomer.getSurname()).isEqualTo(getAllCustomers().getSurname());
        assertThat(otherCustomer.getImage()).isEqualTo(getAllCustomers().getImage());
    }

    @Test
    public void update_one_customer(){
        insertCustomer(customerDTO);
        CustomerDTO newCustomer = new CustomerDTO(
                "jose",
                "déniz",
                "image.jpg");
        int customerId = getAllCustomers().getId();

        shopRepository.update(customerId, newCustomer);

        assertThat(newCustomer.getName()).isEqualTo(getAllCustomers().getName());
        assertThat(customerId).isEqualTo(getAllCustomers().getId());
        assertThat(newCustomer.getSurname()).isEqualTo(getAllCustomers().getSurname());
        assertThat(newCustomer.getImage()).isEqualTo(getAllCustomers().getImage());
    }

    @Test
    public void get_one_customer(){
        insertCustomer(customerDTO);
        Customer customer = getAllCustomers();

        Customer newCustomer = shopRepository.getCustomer(customer.getId());

        assertThat(customerDTO.getName()).isEqualTo(newCustomer.getName());
        assertThat(customerDTO.getSurname()).isEqualTo(newCustomer.getSurname());
        assertThat(customerDTO.getImage()).isEqualTo(newCustomer.getImage());
    }

    private void insertCustomer(CustomerDTO customerDTO) {
        try (Connection connection = this.connection.open()) {
            connection.createQuery("INSERT INTO customers(name, surname, image)" +
                    " VALUES (:name, :surname, :image)")
                    .addParameter("name", customerDTO.getName())
                    .addParameter("surname", customerDTO.getSurname())
                    .addParameter("image", customerDTO.getImage()).executeUpdate();
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

