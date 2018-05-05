package shopApi.services.customerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domains.Customer;
import shopApi.repositories.customerRepository.CustomerRepository;

import java.util.List;

@Service
public class GetAllCustomersService {
    private CustomerRepository customerRepository;

    @Autowired
    public GetAllCustomersService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> execute() {
        return customerRepository.getAllCustomers();
    }
}
