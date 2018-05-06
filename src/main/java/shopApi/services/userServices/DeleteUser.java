package shopApi.services.userServices;

import shopApi.repositories.userRepository.UserRepository;

public class DeleteUser {
    private UserRepository userRepository;

    public DeleteUser(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public void execute(int userId) {
        userRepository.deleteUser(userId);
    }
}
