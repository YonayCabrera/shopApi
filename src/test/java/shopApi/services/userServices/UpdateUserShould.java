package shopApi.services.userServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.domains.User;
import shopApi.domains.UserDTO;
import shopApi.repositories.userRepository.UserRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UpdateUserShould {
    private UserRepository userRepository;
    private UpdateUser updateUser;

    @Before
    public void setUp() throws Exception {
        userRepository = mock(UserRepository.class);
        updateUser = new UpdateUser(userRepository);
    }

    @Test
    public void update_one_customer(){
        User user = new User(
                1,
                "user",
                "user123",
                "user@gmail.com",
                "user");
        UserDTO newUser = new UserDTO(
                "newUser",
                "newUser123",
                "user@gmail.com",
                "user");

        updateUser.execute(user.getId(),newUser);

        verify(userRepository).updateUser(user.getId(), newUser);
    }
}
