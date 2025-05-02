package dbclass.grouptimetablemanagementsystem.user;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    User createUser(final User user) {
        return userRepository.save(user);
    }

    List<User> findUsers() {
        return userRepository.findAll();
    }

    Optional<User> findUserById(final Long id) {
        return userRepository.findById(id);
    }

    public int deleteCustomer(final Long id) {
        return userRepository.deleteById(id);
    }
}
