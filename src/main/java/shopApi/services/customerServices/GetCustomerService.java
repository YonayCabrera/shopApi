package shopApi.services.customerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domains.Customer;
import shopApi.repositories.customerRepository.CustomerRepository;

@Service
public class GetCustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public GetCustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public Customer execute(int customerId) {
        return customerRepository.getCustomer(customerId);
    }
}
