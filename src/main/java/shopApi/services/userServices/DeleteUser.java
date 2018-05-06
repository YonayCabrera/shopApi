package shopApi.services.userServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.repositories.userRepository.UserRepository;

@Service
public class DeleteUser {
    private UserRepository userRepository;

    @Autowired
    public DeleteUser(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void execute(int userId) {
        userRepository.deleteUser(userId);
    }
}
