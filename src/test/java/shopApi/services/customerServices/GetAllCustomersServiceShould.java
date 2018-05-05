package shopApi.services.customerServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.repositories.customerRepository.CustomerRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GetAllCustomersServiceShould {

    private CustomerRepository customerRepository;
    private GetAllCustomersService getAllCustomersService;

    @Before
    public void setUp() throws Exception {
        customerRepository = mock(CustomerRepository.class);
        getAllCustomersService = new GetAllCustomersService(customerRepository);
    }

    @Test
    public void get_all_customers(){
        getAllCustomersService.execute();

        verify(customerRepository).getAllCustomers();
    }
}
