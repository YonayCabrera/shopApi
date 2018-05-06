package shopApi.services.userServices;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domain.UserDTO;
import shopApi.repositories.userRepository.UserRepository;

import java.nio.charset.StandardCharsets;

@Service
public class UpdateUser {
    private UserRepository userRepository;

    @Autowired
    public UpdateUser(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void execute(int userId, UserDTO userDTO) {
        String hashPassword = HashPassword(userDTO);
        userDTO.setPassword(hashPassword);

        userRepository.updateUser(userId,userDTO);
    }

    private String HashPassword(UserDTO userDTO) {
        return Hashing.sha256()
                .hashString(userDTO.getPassword(), StandardCharsets.UTF_8)
                .toString();
    }
}
