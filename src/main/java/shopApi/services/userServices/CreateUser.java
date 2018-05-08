package shopApi.services.userServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopApi.domain.UserDTO;
import shopApi.repositories.userRepository.UserRepository;

import java.util.Date;

import static shopApi.domain.Tools.hashPassword;

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



    private void generateKey(UserDTO userDTO){
        userDTO.setToken(hashPassword(String.valueOf(new Date().getTime())));
    }
}
