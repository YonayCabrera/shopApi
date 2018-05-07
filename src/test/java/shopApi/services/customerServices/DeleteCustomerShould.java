package shopApi.services.customerServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.domain.Customer;
import shopApi.repositories.customerRepository.CustomerRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DeleteCustomerShould {

    private CustomerRepository customerRepository;
    private DeleteCustomer deleteCustomer;

    @Before
    public void setUp() throws Exception {
        customerRepository = mock(CustomerRepository.class);
        deleteCustomer = new DeleteCustomer(customerRepository);
    }

    @Test
    public void remove_one_customer(){
        Customer customer = new Customer(
                1,
                "yonay",
                "cabrera",
                "image.jpg",
                "yonay");
        deleteCustomer.execute(customer.getId());

        verify(customerRepository).remove(customer.getId());
    }
}
