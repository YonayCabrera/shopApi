package shopApi.services;

import shopApi.repositories.ShopRepository;

public class GetAllCustomers {
    private ShopRepository shopRepository;

    public GetAllCustomers(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public void execute() {
        shopRepository.getAllCustomers();
    }
}
