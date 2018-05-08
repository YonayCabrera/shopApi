package shopApi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopApi.domain.Customer;
import shopApi.domain.CustomerDTO;
import shopApi.domain.Roles;
import shopApi.domain.User;
import shopApi.services.customerServices.*;
import shopApi.services.userServices.CheckToken;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private GetAllCustomers getAllCustomers;
    private UpdateCustomer updateCustomer;
    private GetCustomer getCustomer;
    private DeleteCustomer deleteCustomer;
    private CreateCustomer createCustomer;
    private CheckToken checkToken;

    @Autowired
    public CustomerController(GetAllCustomers getAllCustomers,
                              UpdateCustomer updateCustomer,
                              GetCustomer getCustomer,
                              DeleteCustomer deleteCustomer,
                              CreateCustomer createCustomer,
                              CheckToken checkToken) {

        this.getAllCustomers = getAllCustomers;
        this.updateCustomer = updateCustomer;
        this.getCustomer = getCustomer;
        this.deleteCustomer = deleteCustomer;
        this.createCustomer = createCustomer;
        this.checkToken = checkToken;
    }

    @GetMapping("/customers")
    public List<CustomerDTO> allCustomers(@RequestParam(value = "token") String token) {
        User user = checkToken.execute(token);

        if ((user.getRole().equals(Roles.USER.toString()) ||
                user.getRole().equals(Roles.ADMIN.toString()))) {
            return getAllCustomers.execute().stream().map(Customer::toDTO).collect(Collectors.toList());
        }
        return null;
    }

    @ResponseBody
    @PutMapping("/customers/{id}")
    public void updateCustomer(@PathVariable("id") int id,
                               @RequestBody CustomerDTO customerDTO,
                               @RequestParam(value = "token") String token) {
        User user = checkToken.execute(token);

        if (user.getRole().equals(Roles.USER.toString()) ||
                user.getRole().equals(Roles.ADMIN.toString())) {

            updateCustomer.execute(id, customerDTO);
        }
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") int id,
                                   @RequestParam(value = "token") String token) {

        User user = checkToken.execute(token);

        if (user.getRole().equals(Roles.USER.toString()) ||
                user.getRole().equals(Roles.ADMIN.toString())) {
            return getCustomer.execute(id).toDTO();
        }
        return null;
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable("id") int customerId,
                               @RequestParam(value = "token") String token) {

        User user = checkToken.execute(token);

        if (user.getRole().equals(Roles.USER.toString()) ||
                user.getRole().equals(Roles.ADMIN.toString())) {
            deleteCustomer.execute(customerId);
        }
    }

    @ResponseBody
    @PostMapping("/createCustomer")
    public void createCustomer(@RequestBody CustomerDTO customerDTO,
                               @RequestParam(value = "token") String token) {

        User user = checkToken.execute(token);

        if (user.getRole().equals(Roles.USER.toString()) ||
                user.getRole().equals(Roles.ADMIN.toString())) {
            customerDTO.setCreatedBy(user.getEmail());
            customerDTO.setLastModification(user.getEmail());
            createCustomer.execute(customerDTO);
        }
    }

}
