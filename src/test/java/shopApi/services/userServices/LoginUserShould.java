package shopApi.services.userServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.domain.LoginDTO;
import shopApi.repositories.userRepository.UserRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginUserShould {
    private UserRepository userRepository;
    private LogUser logUser;

    @Before
    public void setUp() throws Exception {
        userRepository = mock(UserRepository.class);
        logUser = new LogUser(userRepository);
    }

    @Test
    public void log_user(){
        LoginDTO logDTO = new LoginDTO("yonaycl@gmail.com","1234");

        logUser.execute(logDTO);

        verify(userRepository).verifySession(logDTO);
    }
}
