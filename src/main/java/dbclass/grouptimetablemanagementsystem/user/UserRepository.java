package dbclass.grouptimetablemanagementsystem.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(final User user);

    Optional<User> findById(final Long id);

    List<User> findAll();

    int update(final User user);

    int deleteById(final Long id);
}
