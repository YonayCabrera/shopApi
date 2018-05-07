package shopApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopApi.domain.Roles;
import shopApi.domain.User;
import shopApi.domain.UserDTO;
import shopApi.services.userServices.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private GetAllUsers getAllUsers;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private CheckToken checkToken;

    @Autowired
    public UserController(GetAllUsers getAllUsers, CreateUser createUser,
                          DeleteUser deleteUser, UpdateUser updateUser, CheckToken checkToken) {

        this.getAllUsers = getAllUsers;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
        this.checkToken = checkToken;
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(@RequestParam(value = "token") String token) {
        User user = checkToken.execute(token);
        System.out.println(user.getRole());
        if ((user.getRole().equals(Roles.ADMIN.toString()))) {
            return getAllUsers.execute().stream().map(User::toDTO).collect(Collectors.toList());
        }
        return null;
    }

    @ResponseBody
    @PostMapping("/createUser")
    public void createUser(@RequestBody UserDTO userDTO,
                           @RequestParam(value = "token") String token) {
        User user = checkToken.execute(token);

        if ((user.getRole().equals(Roles.ADMIN.toString()))) {
            createUser.execute(userDTO);
        }
    }

    @ResponseBody
    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable("id") int userId, @RequestBody UserDTO userDTO,
                           @RequestParam(value = "token") String token) {
        User user = checkToken.execute(token);

        if ((user.getRole().equals(Roles.ADMIN.toString()))) {
            updateUser.execute(userId, userDTO);
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int userId,
                           @RequestParam(value = "token") String token){
        User user = checkToken.execute(token);

        if ((user.getRole().equals(Roles.ADMIN.toString()))) {
            deleteUser.execute(userId);
        }
    }
}
