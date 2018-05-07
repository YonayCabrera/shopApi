package shopApi.repositories.userRepository;

import org.springframework.stereotype.Repository;
import shopApi.domain.LoginDTO;
import shopApi.domain.User;
import shopApi.domain.UserDTO;

import java.util.List;

@Repository
public interface UserRepository {
    void save(UserDTO userDTO);

    List<User> getAllUsers();

    void deleteUser(int userId);

    void updateUser(int userId, UserDTO userDTO);

    String verifySession(LoginDTO logDTO);

    boolean checkToken(String token);
}
