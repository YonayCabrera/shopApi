package shopApi.services.customerServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.domain.Customer;
import shopApi.domain.CustomerDTO;
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
                "image.jpg",
                "user1",
                "yonaycl@gmail.com");
        CustomerDTO newCustomer = new CustomerDTO(
                1,
                "jose",
                "deniz",
                "image.jpg",
                "user1",
                "user@gmail.com");

        updateCustomer.execute(customer.getId(),newCustomer);

        verify(customerRepository).update(customer.getId(), newCustomer);
    }
}
