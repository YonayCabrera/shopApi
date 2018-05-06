package shopApi.services.userServices;

import com.google.common.hash.Hashing;
import shopApi.domains.UserDTO;
import shopApi.repositories.userRepository.UserRepository;

import java.nio.charset.StandardCharsets;

public class CreateUser {
    private UserRepository userRepository;

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
