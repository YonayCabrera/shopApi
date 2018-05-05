package shopApi.services;

import org.junit.Before;
import org.junit.Test;
import shopApi.repositories.ShopRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GetOneCustomerServiceShould {

    private ShopRepository shopRepository;
    private GetCustomerService getCustomerService;

    @Before
    public void setUp() throws Exception {
        shopRepository = mock(ShopRepository.class);
        getCustomerService = new GetCustomerService(shopRepository);
    }

    @Test
    public void get_customer(){
        int customerId=1;

        getCustomerService.execute(customerId);

        verify(shopRepository).getCustomer(customerId);
    }
}
