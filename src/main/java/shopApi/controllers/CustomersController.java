package shopApi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopApi.domains.Customer;
import shopApi.domains.CustomerDTO;
import shopApi.services.customerServices.*;

import java.util.List;

@RestController
public class CustomersController {

    private GetAllCustomers getAllCustomers;
    private UpdateCustomer updateCustomer;
    private GetCustomer getCustomer;
    private DeleteCustomer deleteCustomer;
    private CreateCustomer createCustomer;

    @Autowired
    public CustomersController(GetAllCustomers getAllCustomers,
                               UpdateCustomer updateCustomer,
                               GetCustomer getCustomer,
                               DeleteCustomer deleteCustomer,
                               CreateCustomer createCustomer) {

        this.getAllCustomers = getAllCustomers;
        this.updateCustomer = updateCustomer;
        this.getCustomer = getCustomer;
        this.deleteCustomer = deleteCustomer;
        this.createCustomer = createCustomer;
    }

    @GetMapping("/customers")
    public List<Customer> allCustomers() {
        return getAllCustomers.execute();
    }

    @ResponseBody
    @PutMapping("/customers/{id}")
    public void updateCustomer(@PathVariable("id") int id, @RequestBody CustomerDTO customerDTO) {
        updateCustomer.execute(id,customerDTO);
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") int id) {
        return getCustomer.execute(id);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable("id") int customerId){
        deleteCustomer.execute(customerId);
    }

    @ResponseBody
    @PostMapping("/createCustomer")
    public void createCustomer(@RequestBody CustomerDTO customerDTO){
        createCustomer.execute(customerDTO);
    }

}
