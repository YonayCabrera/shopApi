package shopApi.services.customerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domains.Customer;
import shopApi.repositories.customerRepository.CustomerRepository;

@Service
public class GetCustomer {
    private CustomerRepository customerRepository;

    @Autowired
    public GetCustomer(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public Customer execute(int customerId) {
        return customerRepository.getCustomer(customerId);
    }
}
