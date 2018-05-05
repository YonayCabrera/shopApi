package shopApi.repositories.customerRepository;

import org.springframework.stereotype.Repository;
import shopApi.domains.Customer;
import shopApi.domains.CustomerDTO;

import java.util.List;

@Repository
public interface CustomerRepository {

    List<Customer> getAllCustomers();

    void save(CustomerDTO customerDTO);

    void remove(int customerId);

    void update(int id, CustomerDTO customerDTO);

    Customer getCustomer(int customerId);
}
