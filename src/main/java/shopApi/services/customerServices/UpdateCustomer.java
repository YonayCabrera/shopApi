package shopApi.services.customerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domain.CustomerDTO;
import shopApi.repositories.customerRepository.CustomerRepository;

@Service
public class UpdateCustomer {
    private CustomerRepository customerRepository;

    @Autowired
    public UpdateCustomer(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public void execute(int id, CustomerDTO customerDTO) {
        if (!customerDTO.getName().equals("") || !customerDTO.getSurname().equals("")) {
            customerRepository.update(id, customerDTO);
        }
    }
}
