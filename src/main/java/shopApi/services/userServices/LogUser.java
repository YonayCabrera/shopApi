package shopApi.services.userServices;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domain.LoginDTO;
import shopApi.repositories.userRepository.UserRepository;

import java.nio.charset.StandardCharsets;

@Service
public class LogUser {
    private UserRepository userRepository;

    @Autowired
    public LogUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String execute(LoginDTO logDTO) {
        logDTO.setPassword(hashPassword(logDTO.getPassword()));
        return userRepository.verifySession(logDTO);
    }

    private String hashPassword(String password) {
        return Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
    }
}
