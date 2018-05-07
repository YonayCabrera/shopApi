package shopApi.services.userServices;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domain.UserDTO;
import shopApi.repositories.userRepository.UserRepository;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class CreateUser {
    private UserRepository userRepository;

    @Autowired
    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(UserDTO userDTO) {
        String hashPassword = hashPassword(userDTO.getPassword());
        userDTO.setPassword(hashPassword);
        generateKey(userDTO);

        userRepository.save(userDTO);
    }

    private String hashPassword(String password) {
        return Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
    }

    private void generateKey(UserDTO userDTO){
        userDTO.setToken(hashPassword(String.valueOf(new Date().getTime())));
    }
}
