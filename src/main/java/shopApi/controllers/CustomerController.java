package shopApi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopApi.domain.Customer;
import shopApi.domain.CustomerDTO;
import shopApi.services.customerServices.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private GetAllCustomers getAllCustomers;
    private UpdateCustomer updateCustomer;
    private GetCustomer getCustomer;
    private DeleteCustomer deleteCustomer;
    private CreateCustomer createCustomer;

    @Autowired
    public CustomerController(GetAllCustomers getAllCustomers,
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
    public List<CustomerDTO> allCustomers() {
        return getAllCustomers.execute().stream().map(Customer::toDTO).collect(Collectors.toList());
    }

    @ResponseBody
    @PutMapping("/customers/{id}")
    public void updateCustomer(@PathVariable("id") int id, @RequestBody CustomerDTO customerDTO) {
        updateCustomer.execute(id,customerDTO);
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") int id) {
        return getCustomer.execute(id).toDTO();
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
