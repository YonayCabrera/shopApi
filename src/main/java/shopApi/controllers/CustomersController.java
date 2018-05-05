package shopApi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopApi.domains.Customer;
import shopApi.domains.CustomerDTO;
import shopApi.services.*;

import java.util.List;

@RestController
public class CustomersController {

    private GetAllCustomersService getAllCustomersService;
    private UpdateCustomerService updateCustomerService;
    private GetCustomerService getCustomerService;
    private DeleteCustomerService deleteCustomerService;
    private CreateCustomerService createCustomerService;

    @Autowired
    public CustomersController(GetAllCustomersService getAllCustomersService,
                               UpdateCustomerService updateCustomerService,
                               GetCustomerService getCustomerService,
                               DeleteCustomerService deleteCustomerService,
                               CreateCustomerService createCustomerService) {
        this.getAllCustomersService = getAllCustomersService;
        this.updateCustomerService = updateCustomerService;
        this.getCustomerService = getCustomerService;
        this.deleteCustomerService = deleteCustomerService;
        this.createCustomerService = createCustomerService;
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

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") int id) {
        return getCustomerService.execute(id);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable("id") int customerId){
        deleteCustomerService.execute(customerId);
    }

    @ResponseBody
    @PostMapping("/createCustomer")
    public void createCustomer(@RequestBody CustomerDTO customerDTO){
        createCustomerService.execute(customerDTO);
    }

}
