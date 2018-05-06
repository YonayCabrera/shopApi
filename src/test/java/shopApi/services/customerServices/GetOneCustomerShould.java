package shopApi.services.customerServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.repositories.customerRepository.CustomerRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GetOneCustomerShould {

    private CustomerRepository customerRepository;
    private GetCustomer getCustomer;

    @Before
    public void setUp() throws Exception {
        customerRepository = mock(CustomerRepository.class);
        getCustomer = new GetCustomer(customerRepository);
    }

    @Test
    public void get_customer(){
        int customerId=1;

        getCustomer.execute(customerId);

        verify(customerRepository).getCustomer(customerId);
    }
}
