package dbclass.grouptimetablemanagementsystem.user;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    User createUser(final User user) {
        if (userRepository.findByUserNumber(user.getUserNumber()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 학번입니다: " + user.getUserNumber());
        }
        return userRepository.save(user);
    }

    List<User> findUsers() {
        return userRepository.findAll();
    }

    Optional<User> findUserByUserNumber(final int userNumber) {
        return userRepository.findByUserNumber(userNumber);
    }

    public int deleteCustomer(final int userNumber) {
        return userRepository.deleteByUserNumber(userNumber);
    }
}
