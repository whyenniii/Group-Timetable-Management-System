package dbclass.grouptimetablemanagementsystem.user;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody final UserRequest request) {
        User user = new User(
                request.getUserNumber(), request.getUserName()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findUsers());
    }

    @GetMapping("/{userNumber}")
    public ResponseEntity<User> getUser(@PathVariable("userNumber") final int userNumber) {
        Optional<User> user = userService.findUserByUserNumber(userNumber);
        return user.isPresent() ? ResponseEntity.ok(user.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userNumber}")
    public ResponseEntity<String> deleteUser(@PathVariable("userNumber") final int userNumber) {
        userService.deleteCustomer(userNumber);
        return ResponseEntity.ok("사용자 정보 삭제 성공");
    }
}
