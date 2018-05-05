package shopApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domains.Customer;
import shopApi.repositories.ShopRepository;

@Service
public class UpdateCustomerService {
    private ShopRepository shopRepository;

    @Autowired
    public UpdateCustomerService(ShopRepository shopRepository) {

        this.shopRepository = shopRepository;
    }

    public void execute(int id, Customer customer) {
        shopRepository.update(id, customer);
    }
}
