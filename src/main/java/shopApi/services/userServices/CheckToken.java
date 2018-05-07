package shopApi.services.userServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domain.User;
import shopApi.repositories.userRepository.UserRepository;

@Service
public class CheckToken {
    private UserRepository userRepository;

    @Autowired
    public CheckToken(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String token) {
        return userRepository.checkToken(token);
    }
}
