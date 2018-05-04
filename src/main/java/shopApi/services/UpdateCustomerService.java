package shopApi.services;

import shopApi.domains.Customer;
import shopApi.repositories.ShopRepository;

public class UpdateCustomerService {
    private ShopRepository shopRepository;

    public UpdateCustomerService(ShopRepository shopRepository) {

        this.shopRepository = shopRepository;
    }

    public void execute(int id, Customer customer) {
        shopRepository.update(id, customer);
    }
}
