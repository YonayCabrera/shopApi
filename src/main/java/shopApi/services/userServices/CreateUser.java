package shopApi.services.userServices;

import shopApi.domains.UserDTO;
import shopApi.repositories.userRepository.UserRepository;

public class CreateUser {
    private UserRepository userRepository;

    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(UserDTO userDTO) {
        userRepository.save(userDTO);
    }
}
