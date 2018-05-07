package shopApi.services.userServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.repositories.userRepository.UserRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckTokenShould {
    private UserRepository userRepository;
    private CheckToken checkToken;

    @Before
    public void setUp() throws Exception {
        userRepository = mock(UserRepository.class);
        checkToken = new CheckToken(userRepository);
    }

    @Test
    public void check_token(){
        String token = "1234";

        checkToken.execute(token);

        verify(userRepository).checkToken(token);
    }
}
