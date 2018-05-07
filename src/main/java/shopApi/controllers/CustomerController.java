package shopApi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopApi.domain.Customer;
import shopApi.domain.CustomerDTO;
import shopApi.services.customerServices.*;
import shopApi.services.userServices.CheckKey;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private GetAllCustomers getAllCustomers;
    private UpdateCustomer updateCustomer;
    private GetCustomer getCustomer;
    private DeleteCustomer deleteCustomer;
    private CreateCustomer createCustomer;
    private CheckKey checkKey;

    @Autowired
    public CustomerController(GetAllCustomers getAllCustomers,
                              UpdateCustomer updateCustomer,
                              GetCustomer getCustomer,
                              DeleteCustomer deleteCustomer,
                              CreateCustomer createCustomer,
                              CheckKey checkKey) {

        this.getAllCustomers = getAllCustomers;
        this.updateCustomer = updateCustomer;
        this.getCustomer = getCustomer;
        this.deleteCustomer = deleteCustomer;
        this.createCustomer = createCustomer;
        this.checkKey = checkKey;
    }

    @GetMapping("/customers")
    public List<CustomerDTO> allCustomers(@RequestParam(value = "key") String key) {
        if (checkKey.execute(key)) {
            return getAllCustomers.execute().stream().map(Customer::toDTO).collect(Collectors.toList());
        }
        return null;
    }

    @ResponseBody
    @PutMapping("/customers/{id}")
    public void updateCustomer(@PathVariable("id") int id,
                               @RequestBody CustomerDTO customerDTO,
                               @RequestParam(value = "key") String key) {
        if (checkKey.execute(key)) {
            updateCustomer.execute(id, customerDTO);
        }
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") int id,
                                   @RequestParam(value = "key") String key) {
        if (checkKey.execute(key)) {
            return getCustomer.execute(id).toDTO();
        }
        return null;
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable("id") int customerId,
                               @RequestParam(value = "key") String key) {
        if (checkKey.execute(key)) {
            deleteCustomer.execute(customerId);
        }
    }

    @ResponseBody
    @PostMapping("/createCustomer")
    public void createCustomer(@RequestBody CustomerDTO customerDTO,
                               @RequestParam(value = "key") String key) {
        if (checkKey.execute(key)) {
            createCustomer.execute(customerDTO);
        }
    }

}
