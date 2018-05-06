package shopApi.services.userServices;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domain.UserDTO;
import shopApi.repositories.userRepository.UserRepository;

import java.nio.charset.StandardCharsets;

@Service
public class CreateUser {
    private UserRepository userRepository;

    @Autowired
    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(UserDTO userDTO) {
        String hashPassword = HashPassword(userDTO);
        userDTO.setPassword(hashPassword);

        userRepository.save(userDTO);
    }

    private String HashPassword(UserDTO userDTO) {
        return Hashing.sha256()
                .hashString(userDTO.getPassword(), StandardCharsets.UTF_8)
                .toString();
    }
}
