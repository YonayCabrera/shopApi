package shopApi.services;

import shopApi.domains.Customer;
import shopApi.repositories.ShopRepository;

public class DeleteCustomerService {
    private ShopRepository shopRepository;

    public DeleteCustomerService(ShopRepository shopRepository) {

        this.shopRepository = shopRepository;
    }

    public void execute(Customer customer) {
        shopRepository.remove(customer);
    }
}
