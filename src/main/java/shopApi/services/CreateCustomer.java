package shopApi.services;

import shopApi.domains.Customer;
import shopApi.repositories.ShopRepository;

public class CreateCustomer {
    private ShopRepository shopRepository;

    public CreateCustomer(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public void execute(Customer customer) {
        shopRepository.save(customer);
    }
}
