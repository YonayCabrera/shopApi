package shopApi.services.userServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domains.UserDTO;
import shopApi.repositories.userRepository.UserRepository;

@Service
public class UpdateUser {
    private UserRepository userRepository;

    @Autowired
    public UpdateUser(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void execute(int userId, UserDTO userDTO) {
        userRepository.updateUser(userId,userDTO);
    }
}
