package dbclass.grouptimetablemanagementsystem.user.repository;

import static org.assertj.core.api.Assertions.assertThat;

import dbclass.grouptimetablemanagementsystem.user.User;
import dbclass.grouptimetablemanagementsystem.user.UserRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class JdbcTemplateUserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {
        User user = new User(202230102, "신보연");

        User createUser = userRepository.save(user);

        User findUser = userRepository.findById(createUser.getId()).get();
        assertThat(findUser).isEqualTo(createUser);
    }

    @Test
    void update() {
        User user1 = new User(20221023, "신보연아");
        User createUser = userRepository.save(user1);

        createUser.setUserNumber(2022);
        userRepository.update(createUser);
        User updatedUser = userRepository.findById(createUser.getId()).get();
        assertThat(updatedUser).isEqualTo(createUser);
    }

    @Test
    void findAll() {
        User user1 = new User(20221023, "신보연");
        User user2 = new User(20221037, "이혜현");
        User user3 = new User(20221038, "임예은");

        List<User> expectedCustomerList = List.of(
                userRepository.save(user1),
                userRepository.save(user2),
                userRepository.save(user3));

        List<User> actualCustomerList = userRepository.findAll();

        assertThat(actualCustomerList.size()).isEqualTo(expectedCustomerList.size());
        assertThat(actualCustomerList).containsExactlyInAnyOrderElementsOf(expectedCustomerList);
    }


    @Test
    void deleteById() {
        User user1 = new User(20221023, "신보연");

        User createUser = userRepository.save(user1);
        userRepository.deleteById(createUser.getId());

        assertThat(userRepository.findById(createUser.getId())).isEmpty();
    }
}