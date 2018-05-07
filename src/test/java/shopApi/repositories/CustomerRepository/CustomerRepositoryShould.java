package shopApi.repositories.CustomerRepository;

import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import shopApi.domain.Customer;
import shopApi.domain.CustomerDTO;
import shopApi.repositories.BaseRepositoryShould;
import shopApi.repositories.customerRepository.CustomerRepositoryPostgreSql;

import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.codehaus.groovy.runtime.InvokerHelper.asList;

public class CustomerRepositoryShould extends BaseRepositoryShould {
    @Override
    protected List<String> deleteFromTables() {
        return asList("customers");
    }

    private Sql2o connection;
    private CustomerRepositoryPostgreSql customerRepository;
    private CustomerDTO customerDTO;


    @Before
    public void given_a_repository_and_a_database() {
        connection = new Sql2o(connectionTestDatabase, dbUser, dbPassword);
        customerRepository = new CustomerRepositoryPostgreSql(connectionTestDatabase);
        customerDTO = new CustomerDTO(1,"yonay","cabrera","image.png","yonay");
    }

    @Test
    public void get_all_customers(){
        insertCustomer(customerDTO);

        List<Customer>customers = customerRepository.getAllCustomers();

        assertThat(customerDTO.getName()).isEqualTo(customers.get(0).getName());
    }

    @Test
    public void save_one_customer(){
        customerRepository.save(customerDTO);

        Customer newCustomer = getAllCustomers();

        assertThat(newCustomer.getName()).isEqualTo(customerDTO.getName());
        assertThat(newCustomer.getSurname()).isEqualTo(customerDTO.getSurname());
        assertThat(newCustomer.getImage()).isEqualTo(customerDTO.getImage());
    }

    @Test
    public void remove_one_customer(){
        CustomerDTO otherCustomer = new CustomerDTO(
                1,
                "jose",
                "déniz",
                "image.jpg",
                "user1");
        insertCustomer(customerDTO);
        insertCustomer(otherCustomer);

        Customer newCustomer = getAllCustomers();
        customerRepository.remove(newCustomer.getId());

        assertThat(otherCustomer.getName()).isEqualTo(getAllCustomers().getName());
        assertThat(otherCustomer.getSurname()).isEqualTo(getAllCustomers().getSurname());
        assertThat(otherCustomer.getImage()).isEqualTo(getAllCustomers().getImage());
    }

    @Test
    public void update_one_customer(){
        insertCustomer(customerDTO);
        CustomerDTO newCustomer = new CustomerDTO(
                1,
                "jose",
                "déniz",
                "image.jpg",
                "user1");
        int customerId = getAllCustomers().getId();

        customerRepository.update(customerId, newCustomer);

        assertThat(newCustomer.getName()).isEqualTo(getAllCustomers().getName());
        assertThat(customerId).isEqualTo(getAllCustomers().getId());
        assertThat(newCustomer.getSurname()).isEqualTo(getAllCustomers().getSurname());
        assertThat(newCustomer.getImage()).isEqualTo(getAllCustomers().getImage());
    }

    @Test
    public void get_one_customer(){
        insertCustomer(customerDTO);
        Customer customer = getAllCustomers();

        Customer newCustomer = customerRepository.getCustomer(customer.getId());

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

