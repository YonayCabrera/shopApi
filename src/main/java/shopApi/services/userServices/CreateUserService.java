package shopApi.services.userServices;

import shopApi.domains.UserDTO;
import shopApi.repositories.userRepository.UserRepository;

public class CreateUserService {
    private UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(UserDTO userDTO) {
        userRepository.save(userDTO);
    }
}
