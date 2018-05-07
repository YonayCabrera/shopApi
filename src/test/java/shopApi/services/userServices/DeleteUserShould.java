package shopApi.services.userServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.domain.Roles;
import shopApi.domain.User;
import shopApi.repositories.userRepository.UserRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DeleteUserShould {
    private UserRepository userRepository;
    private DeleteUser deleteUser;

    @Before
    public void setUp() throws Exception {
        userRepository = mock(UserRepository.class);
        deleteUser = new DeleteUser(userRepository);
    }

    @Test
    public void remove_one_user(){
        User user = new User(
                1,
                "user",
                "user123",
                "user@gmail.com",
                Roles.USER.toString(),
                "1234");
        deleteUser.execute(user.getId());

        verify(userRepository).deleteUser(user.getId());
    }
}
