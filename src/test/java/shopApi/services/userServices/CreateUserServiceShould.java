package shopApi.services.userServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.domains.User;
import shopApi.repositories.userRepository.UserRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateUserServiceShould {

    private UserRepository userRepository;
    private CreateUserService createUserService;

    @Before
    public void setUp() throws Exception {
        userRepository = mock(UserRepository.class);
        createUserService = new CreateUserService(userRepository);
    }

    @Test
    public void add_user(){
        User user = new User("name","password", "email");

        createUserService.execute(user);

        verify(userRepository).createUser(user);
    }
}
