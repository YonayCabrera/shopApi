package shopApi.services.userServices;

import shopApi.domains.User;
import shopApi.repositories.userRepository.UserRepository;

import java.util.List;

public class GetAllUsers {
    private UserRepository userRepository;

    public GetAllUsers(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> execute() {
        return userRepository.getAllUsers();
    }
}
