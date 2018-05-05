package shopApi.services;

import org.junit.Before;
import org.junit.Test;
import shopApi.repositories.ShopRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GetAllCustomersServiceShould {

    private ShopRepository shopRepository;
    private GetAllCustomersService getAllCustomersService;

    @Before
    public void setUp() throws Exception {
        shopRepository = mock(ShopRepository.class);
        getAllCustomersService = new GetAllCustomersService(shopRepository);
    }

    @Test
    public void get_all_customers(){
        getAllCustomersService.execute();

        verify(shopRepository).getAllCustomers();
    }
}
