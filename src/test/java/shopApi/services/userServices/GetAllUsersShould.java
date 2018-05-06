package shopApi.services.userServices;

import org.junit.Before;
import org.junit.Test;
import shopApi.repositories.userRepository.UserRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GetAllUsersShould {
    private UserRepository userRepository;
    private GetAllUsers getAllUsers;

    @Before
    public void setUp() throws Exception {
        userRepository = mock(UserRepository.class);
        getAllUsers = new GetAllUsers(userRepository);
    }

    @Test
    public void get_all_users(){
        getAllUsers.execute();

        verify(userRepository).getAllUsers();
    }
}
