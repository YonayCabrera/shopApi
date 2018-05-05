package shopApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domains.Customer;
import shopApi.repositories.ShopRepository;

@Service
public class CreateCustomerService {
    private ShopRepository shopRepository;

    @Autowired
    public CreateCustomerService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public void execute(Customer customer) {
        shopRepository.save(customer);
    }
}
