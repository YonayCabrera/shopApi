package shopApi.services;

import shopApi.domains.Customer;
import shopApi.repositories.ShopRepository;

public class UpdateCustomerService {
    private ShopRepository shopRepository;

    public UpdateCustomerService(ShopRepository shopRepository) {

        this.shopRepository = shopRepository;
    }

    public void execute(Customer customer) {
        shopRepository.update(customer);
    }
}
