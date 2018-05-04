package shopApi.services;

import org.junit.Test;
import shopApi.repositories.ShopRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GetAllCustomersShould {
    private ShopRepository shopRepository;
    private GetAllCustomersService getAllCustomersService;

    @Test
    public void get_all_customers(){
        shopRepository = mock(ShopRepository.class);
        getAllCustomersService = new GetAllCustomersService(shopRepository);

        getAllCustomersService.execute();

        verify(shopRepository).getAllCustomers();
    }
}
