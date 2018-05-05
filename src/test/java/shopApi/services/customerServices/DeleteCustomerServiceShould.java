package shopApi.services.customerServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.domains.Customer;
import shopApi.repositories.customerRepository.CustomerRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DeleteCustomerServiceShould {

    private CustomerRepository customerRepository;
    private DeleteCustomerService deleteCustomerService;

    @Before
    public void setUp() throws Exception {
        customerRepository = mock(CustomerRepository.class);
        deleteCustomerService = new DeleteCustomerService(customerRepository);
    }

    @Test
    public void remove_one_customer(){
        Customer customer = new Customer(
                1,
                "yonay",
                "cabrera",
                "image.jpg");
        deleteCustomerService.execute(customer.getId());

        verify(customerRepository).remove(customer.getId());
    }
}
