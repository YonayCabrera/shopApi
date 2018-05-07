package shopApi.services.userServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.domain.UserDTO;
import shopApi.repositories.userRepository.UserRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateUserShould {

    private UserRepository userRepository;
    private CreateUser createUser;

    @Before
    public void setUp() throws Exception {
        userRepository = mock(UserRepository.class);
        createUser = new CreateUser(userRepository);
    }

    @Test
    public void add_user(){
        UserDTO userDTO = new UserDTO("name",
                "password",
                "email",
                "user",
                "1234");

        createUser.execute(userDTO);

        verify(userRepository).save(userDTO);
    }
}
