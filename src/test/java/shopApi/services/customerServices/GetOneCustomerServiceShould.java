package shopApi.services.customerServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.repositories.customerRepository.CustomerRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GetOneCustomerServiceShould {

    private CustomerRepository customerRepository;
    private GetCustomerService getCustomerService;

    @Before
    public void setUp() throws Exception {
        customerRepository = mock(CustomerRepository.class);
        getCustomerService = new GetCustomerService(customerRepository);
    }

    @Test
    public void get_customer(){
        int customerId=1;

        getCustomerService.execute(customerId);

        verify(customerRepository).getCustomer(customerId);
    }
}
