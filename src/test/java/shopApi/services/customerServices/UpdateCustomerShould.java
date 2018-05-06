package shopApi.services.customerServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.domains.Customer;
import shopApi.domains.CustomerDTO;
import shopApi.repositories.customerRepository.CustomerRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UpdateCustomerShould {

    private CustomerRepository customerRepository;
    private UpdateCustomer updateCustomer;

    @Before
    public void setUp() throws Exception {
        customerRepository = mock(CustomerRepository.class);
        updateCustomer = new UpdateCustomer(customerRepository);
    }

    @Test
    public void update_one_customer(){
        Customer customer = new Customer(
                1,
                "yonay",
                "cabrera",
                "image.jpg");
        CustomerDTO newCustomer = new CustomerDTO(
                "jose",
                "deniz",
                "image.jpg");

        updateCustomer.execute(customer.getId(),newCustomer);

        verify(customerRepository).update(customer.getId(), newCustomer);
    }
}