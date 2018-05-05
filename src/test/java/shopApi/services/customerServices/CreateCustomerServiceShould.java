package shopApi.services.customerServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.domains.CustomerDTO;
import shopApi.repositories.customerRepository.CustomerRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateCustomerServiceShould {

    private CustomerRepository customerRepository;
    private CreateCustomerService createCustomerService;

    @Before
    public void setUp() throws Exception {
        customerRepository = mock(CustomerRepository.class);
        createCustomerService = new CreateCustomerService(customerRepository);
    }

    @Test
    public void save_one_customer(){
        CustomerDTO customerDTO = new CustomerDTO(
                "yonay",
                "cabrera",
                "image.jpg");

        createCustomerService.execute(customerDTO);

        verify(customerRepository).save(customerDTO);
    }
}
