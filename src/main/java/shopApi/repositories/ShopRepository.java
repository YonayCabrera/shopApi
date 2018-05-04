package shopApi.repositories;

import org.springframework.stereotype.Repository;
import shopApi.domains.Customer;

import java.util.List;

@Repository
public interface ShopRepository {

    List<Customer> getAllCustomers();

    void save(Customer customer);

    void remove(Customer customer);
}
