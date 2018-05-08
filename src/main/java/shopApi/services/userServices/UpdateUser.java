package shopApi.services.userServices;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domain.UserDTO;
import shopApi.repositories.userRepository.UserRepository;

import java.nio.charset.StandardCharsets;

import static shopApi.domain.Tools.hashPassword;

@Service
public class UpdateUser {
    private UserRepository userRepository;

    @Autowired
    public UpdateUser(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void execute(int userId, UserDTO userDTO) {
        if(!userDTO.getPassword().equals("") && !userDTO.getEmail().equals("")) {
            String hashPassword = hashPassword(userDTO.getPassword());
            userDTO.setPassword(hashPassword);

            userRepository.updateUser(userId, userDTO);
        }
    }

}
