package shopApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopApi.domain.User;
import shopApi.domain.UserDTO;
import shopApi.services.userServices.CreateUser;
import shopApi.services.userServices.DeleteUser;
import shopApi.services.userServices.GetAllUsers;
import shopApi.services.userServices.UpdateUser;

import java.util.List;

@RestController
public class UserController {

    private GetAllUsers getAllUsers;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;

    @Autowired
    public UserController(GetAllUsers getAllUsers, CreateUser createUser,
                          DeleteUser deleteUser, UpdateUser updateUser) {

        this.getAllUsers = getAllUsers;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return getAllUsers.execute();
    }

    @ResponseBody
    @PostMapping("/createUser")
    public void createUser(@RequestBody UserDTO userDTO) {
        createUser.execute(userDTO);
    }

    @ResponseBody
    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable("id") int userId, @RequestBody UserDTO userDTO) {
        updateUser.execute(userId, userDTO);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int userId){
        deleteUser.execute(userId);
    }
}
