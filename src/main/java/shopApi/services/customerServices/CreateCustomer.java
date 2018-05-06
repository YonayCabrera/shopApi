package shopApi.services.customerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domain.CustomerDTO;
import shopApi.repositories.customerRepository.CustomerRepository;

@Service
public class CreateCustomer {
    private CustomerRepository customerRepository;

    @Autowired
    public CreateCustomer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(CustomerDTO customerDTO) {
        customerRepository.save(customerDTO);
    }
}
