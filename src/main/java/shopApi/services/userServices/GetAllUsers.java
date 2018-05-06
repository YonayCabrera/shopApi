package shopApi.services.userServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domains.User;
import shopApi.repositories.userRepository.UserRepository;

import java.util.List;

@Service
public class GetAllUsers {
    private UserRepository userRepository;

    @Autowired
    public GetAllUsers(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> execute() {
        return userRepository.getAllUsers();
    }
}
