package shopApi.services;

import org.springframework.stereotype.Service;
import shopApi.repositories.ShopRepository;

@Service
public class GetAllCustomersService {
    private ShopRepository shopRepository;

    public GetAllCustomersService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public void execute() {
        shopRepository.getAllCustomers();
    }
}
