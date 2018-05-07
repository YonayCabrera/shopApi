package shopApi.services.userServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.repositories.userRepository.UserRepository;

@Service
public class CheckKey {
    private UserRepository userRepository;

    @Autowired
    public CheckKey(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute(String key) {
        return userRepository.checkKey(key);
    }
}
