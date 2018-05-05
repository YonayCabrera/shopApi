package shopApi.services;

import org.junit.Before;
import org.junit.Test;
import shopApi.domains.Customer;
import shopApi.domains.CustomerDTO;
import shopApi.repositories.ShopRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateCustomerServiceShould {

    private ShopRepository shopRepository;
    private CreateCustomerService createCustomerService;

    @Before
    public void setUp() throws Exception {
        shopRepository = mock(ShopRepository.class);
        createCustomerService = new CreateCustomerService(shopRepository);
    }

    @Test
    public void save_one_customer(){
        CustomerDTO customerDTO = new CustomerDTO(
                "yonay",
                "cabrera",
                "image.jpg");

        createCustomerService.execute(customerDTO);

        verify(shopRepository).save(customerDTO);
    }
}
