package dbclass.grouptimetablemanagementsystem.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(final User user);

    Optional<User> findByUserNumber(final int userNumber);

    List<User> findAll();

    int update(final User user);

    int deleteByUserNumber(final int userNumber);
}
