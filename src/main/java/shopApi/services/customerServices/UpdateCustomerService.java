package shopApi.services.customerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domains.CustomerDTO;
import shopApi.repositories.customerRepository.CustomerRepository;

@Service
public class UpdateCustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public UpdateCustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public void execute(int id, CustomerDTO customerDTO) {
        customerRepository.update(id, customerDTO);
    }
}
