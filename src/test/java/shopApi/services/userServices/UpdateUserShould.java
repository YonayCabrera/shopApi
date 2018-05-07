package shopApi.services.userServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.domain.Roles;
import shopApi.domain.User;
import shopApi.domain.UserDTO;
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
                Roles.USER.toString(),
                "1234");
        UserDTO newUser = new UserDTO(1,
                "newUser",
                "newUser123",
                "user@gmail.com",
                Roles.USER.toString(),
                "1234");

        updateUser.execute(user.getId(),newUser);

        verify(userRepository).updateUser(user.getId(), newUser);
    }
}
