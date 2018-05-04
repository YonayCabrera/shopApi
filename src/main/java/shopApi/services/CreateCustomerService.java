package shopApi.services;

import shopApi.domains.Customer;
import shopApi.repositories.ShopRepository;

public class CreateCustomerService {
    private ShopRepository shopRepository;

    public CreateCustomerService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public void execute(Customer customer) {
        shopRepository.save(customer);
    }
}
