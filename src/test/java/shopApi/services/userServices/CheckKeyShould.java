package shopApi.services.userServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.repositories.userRepository.UserRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckKeyShould {
    private UserRepository userRepository;
    private CheckKey checkKey;

    @Before
    public void setUp() throws Exception {
        userRepository = mock(UserRepository.class);
        checkKey = new CheckKey(userRepository);
    }

    @Test
    public void check_key(){
        String key = "1234";

        checkKey.execute(key);

        verify(userRepository).checkToken(key);
    }
}
