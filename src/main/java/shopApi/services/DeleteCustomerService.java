package shopApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domains.Customer;
import shopApi.repositories.ShopRepository;

@Service
public class DeleteCustomerService {
    private ShopRepository shopRepository;

    @Autowired
    public DeleteCustomerService(ShopRepository shopRepository) {

        this.shopRepository = shopRepository;
    }

    public void execute(int customerId) {
        shopRepository.remove(customerId);
    }
}
