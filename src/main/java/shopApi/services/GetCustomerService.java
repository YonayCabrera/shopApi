package shopApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domains.Customer;
import shopApi.repositories.ShopRepository;

@Service
public class GetCustomerService {
    private ShopRepository shopRepository;

    @Autowired
    public GetCustomerService(ShopRepository shopRepository) {

        this.shopRepository = shopRepository;
    }

    public Customer execute(int customerId) {
        return shopRepository.getCustomer(customerId);
    }
}
