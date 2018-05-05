package shopApi.services.userServices;

import shopApi.domains.User;
import shopApi.repositories.userRepository.UserRepository;

public class CreateUserService {
    private UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(User user) {
        userRepository.createUser(user);
    }
}
