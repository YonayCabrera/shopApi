package shopApi.repositories.userRepository;

import org.springframework.stereotype.Repository;
import shopApi.domains.User;

@Repository
public interface UserRepository {
    void createUser(User user);
}
