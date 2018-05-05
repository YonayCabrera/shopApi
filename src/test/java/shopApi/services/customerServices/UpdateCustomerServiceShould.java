package shopApi.services.customerServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.domains.Customer;
import shopApi.domains.CustomerDTO;
import shopApi.repositories.customerRepository.CustomerRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UpdateCustomerServiceShould {

    private CustomerRepository customerRepository;
    private UpdateCustomerService updateCustomerService;

    @Before
    public void setUp() throws Exception {
        customerRepository = mock(CustomerRepository.class);
        updateCustomerService = new UpdateCustomerService(customerRepository);
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

        updateCustomerService.execute(customer.getId(),newCustomer);

        verify(customerRepository).update(customer.getId(), newCustomer);
    }
}
