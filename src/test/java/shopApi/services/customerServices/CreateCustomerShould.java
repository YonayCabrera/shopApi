package shopApi.services.customerServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.domain.CustomerDTO;
import shopApi.repositories.customerRepository.CustomerRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateCustomerShould {

    private CustomerRepository customerRepository;
    private CreateCustomer createCustomer;

    @Before
    public void setUp() throws Exception {
        customerRepository = mock(CustomerRepository.class);
        createCustomer = new CreateCustomer(customerRepository);
    }

    @Test
    public void save_one_customer(){
        CustomerDTO customerDTO = new CustomerDTO(
                1,
                "yonay",
                "cabrera",
                "image.jpg",
                "yonay",
                "yonaycl@gmail.com");

        createCustomer.execute(customerDTO);

        verify(customerRepository).save(customerDTO);
    }
}
