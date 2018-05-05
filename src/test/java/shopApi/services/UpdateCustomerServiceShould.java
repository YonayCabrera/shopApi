package shopApi.services;

import org.junit.Before;
import org.junit.Test;
import shopApi.domains.Customer;
import shopApi.domains.CustomerDTO;
import shopApi.repositories.ShopRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UpdateCustomerServiceShould {

    private ShopRepository shopRepository;
    private UpdateCustomerService updateCustomerService;

    @Before
    public void setUp() throws Exception {
        shopRepository = mock(ShopRepository.class);
        updateCustomerService = new UpdateCustomerService(shopRepository);
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

        verify(shopRepository).update(customer.getId(), newCustomer);
    }
}
