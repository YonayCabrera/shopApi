package shopApi.services;

import shopApi.repositories.ShopRepository;

public class GetAllCustomersService {
    private ShopRepository shopRepository;

    public GetAllCustomersService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public void execute() {
        shopRepository.getAllCustomers();
    }
}
