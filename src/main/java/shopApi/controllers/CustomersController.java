package shopApi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import shopApi.domains.Customer;
import shopApi.services.GetAllCustomersService;
import shopApi.services.UpdateCustomerService;

import java.util.List;

@RestController
public class CustomersController {

    private GetAllCustomersService getAllCustomersService;
    private UpdateCustomerService updateCustomerService;

    @Autowired
    public CustomersController(GetAllCustomersService getAllCustomersService,
                               UpdateCustomerService updateCustomerService) {
        this.getAllCustomersService = getAllCustomersService;
        this.updateCustomerService = updateCustomerService;
    }

    @GetMapping("/customers")
    public List<Customer> allCustomers() {
        return getAllCustomersService.execute();
    }

    @PutMapping("/customer/:id")
    public Customer updateCustomer() {
        return null;
    }

}
