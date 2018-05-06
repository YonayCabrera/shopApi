package shopApi.services.userServices;

import shopApi.domains.UserDTO;
import shopApi.repositories.userRepository.UserRepository;

public class UpdateUser {
    private UserRepository userRepository;

    public UpdateUser(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void execute(int userId, UserDTO userDTO) {
        userRepository.updateUser(userId,userDTO);
    }
}
