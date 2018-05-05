package shopApi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopApi.domains.Customer;
import shopApi.domains.CustomerDTO;
import shopApi.services.GetAllCustomersService;
import shopApi.services.GetCustomerService;
import shopApi.services.UpdateCustomerService;

import java.util.List;

@RestController
public class CustomersController {

    private GetAllCustomersService getAllCustomersService;
    private UpdateCustomerService updateCustomerService;
    private GetCustomerService getCustomerService;

    @Autowired
    public CustomersController(GetAllCustomersService getAllCustomersService,
                               UpdateCustomerService updateCustomerService,
                               GetCustomerService getCustomerService) {
        this.getAllCustomersService = getAllCustomersService;
        this.updateCustomerService = updateCustomerService;
        this.getCustomerService = getCustomerService;
    }

    @GetMapping("/customers")
    public List<Customer> allCustomers() {
        return getAllCustomersService.execute();
    }

    @ResponseBody
    @PutMapping("/customers/{id}")
    public void updateCustomer(@PathVariable("id") int id, @RequestBody CustomerDTO customerDTO) {
        updateCustomerService.execute(id,customerDTO);
    }

    @ResponseBody
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") int id) {
        return getCustomerService.execute(id);
    }

}
