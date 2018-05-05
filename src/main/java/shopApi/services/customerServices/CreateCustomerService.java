package shopApi.services.customerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domains.CustomerDTO;
import shopApi.repositories.customerRepository.CustomerRepository;

@Service
public class CreateCustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CreateCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(CustomerDTO customerDTO) {
        customerRepository.save(customerDTO);
    }
}
