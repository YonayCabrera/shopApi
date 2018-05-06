package shopApi.services.customerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domain.Customer;
import shopApi.repositories.customerRepository.CustomerRepository;

import java.util.List;

@Service
public class GetAllCustomers {
    private CustomerRepository customerRepository;

    @Autowired
    public GetAllCustomers(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> execute() {
        return customerRepository.getAllCustomers();
    }
}
