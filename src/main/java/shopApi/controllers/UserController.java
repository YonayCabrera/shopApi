package shopApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shopApi.domains.User;
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
                          DeleteUser deleteUser, UpdateUser updateUser){

        this.getAllUsers = getAllUsers;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return getAllUsers.execute();
    }
}
