package shopApi.services.customerServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.repositories.customerRepository.CustomerRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GetAllCustomersShould {

    private CustomerRepository customerRepository;
    private GetAllCustomers getAllCustomers;

    @Before
    public void setUp() throws Exception {
        customerRepository = mock(CustomerRepository.class);
        getAllCustomers = new GetAllCustomers(customerRepository);
    }

    @Test
    public void get_all_customers(){
        getAllCustomers.execute();

        verify(customerRepository).getAllCustomers();
    }
}
