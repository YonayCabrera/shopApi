package shopApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domains.Customer;
import shopApi.repositories.ShopRepository;

import java.util.List;

@Service
public class GetAllCustomersService {
    private ShopRepository shopRepository;

    @Autowired
    public GetAllCustomersService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Customer> execute() {
        return shopRepository.getAllCustomers();
    }
}
