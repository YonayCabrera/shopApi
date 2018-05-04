package shopApi.services;

import org.junit.Before;
import org.junit.Test;
import shopApi.domains.Customer;
import shopApi.repositories.ShopRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DeleteCustomerServiceShould {

    private ShopRepository shopRepository;
    private DeleteCustomerService deleteCustomerService;

    @Before
    public void setUp() throws Exception {
        shopRepository = mock(ShopRepository.class);
        deleteCustomerService = new DeleteCustomerService(shopRepository);
    }

    @Test
    public void remove_one_customer(){
        Customer customer = new Customer(
                1,
                "yonay",
                "cabrera",
                "image.jpg");
        deleteCustomerService.execute(customer);

        verify(shopRepository).remove(customer);
    }
}
