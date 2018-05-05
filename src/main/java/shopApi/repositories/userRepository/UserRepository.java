package shopApi.repositories.userRepository;

import org.springframework.stereotype.Repository;
import shopApi.domains.User;
import shopApi.domains.UserDTO;

@Repository
public interface UserRepository {
    void save(UserDTO userDTO);
}
