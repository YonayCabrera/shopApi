package shopApi.services.customerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.repositories.customerRepository.CustomerRepository;

@Service
public class DeleteCustomer {
    private CustomerRepository customerRepository;

    @Autowired
    public DeleteCustomer(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public void execute(int customerId) {
        customerRepository.remove(customerId);
    }
}
