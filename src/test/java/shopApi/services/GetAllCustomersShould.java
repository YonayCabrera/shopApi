package shopApi.services;

import org.junit.Test;
import shopApi.repositories.ShopRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GetAllCustomersShould {
    private ShopRepository shopRepository;
    private GetAllCustomers getAllCustomers;

    @Test
    public void get_all_customers(){
        shopRepository = mock(ShopRepository.class);
        getAllCustomers = new GetAllCustomers(shopRepository);

        getAllCustomers.execute();

        verify(shopRepository).getAllCustomers();
    }
}
