package shopApi.repositories.userRepository;

import org.springframework.stereotype.Repository;
import shopApi.domains.User;
import shopApi.domains.UserDTO;

import java.util.List;

@Repository
public interface UserRepository {
    void save(UserDTO userDTO);

    List<User> getAllUsers();

    void deleteUser(int userId);

    void updateUser(int userId, UserDTO userDTO);
}
