package shopApi.services.userServices;

import shopApi.domain.LoginDTO;
import shopApi.repositories.userRepository.UserRepository;

public class LogUser {
    private UserRepository userRepository;

    public LogUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String execute(LoginDTO logDTO) {
        return userRepository.verifySession(logDTO);
    }
}
