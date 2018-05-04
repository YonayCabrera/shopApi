package shopApi.services;

import org.junit.Before;
import org.junit.Test;
import shopApi.domains.Customer;
import shopApi.repositories.ShopRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateCustomerShould {

    private ShopRepository shopRepository;
    private CreateCustomer createCustomer;

    @Before
    public void setUp() throws Exception {
        shopRepository = mock(ShopRepository.class);
        createCustomer = new CreateCustomer(shopRepository);
    }

    @Test
    public void save_one_customer(){
        Customer customer = new Customer(
                1,
                "yonay",
                "cabrera",
                "image.jpg");

        createCustomer.execute(customer);

        verify(shopRepository).save(customer);
    }
}
