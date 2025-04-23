package dbclass.grouptimetablemanagementsystem.user;

import java.util.Objects;

public class User {
    private Long id;
    private int userNumber;
    private String userName;

    public User() {
    }

    public User(final Long id, final int userNumber, final String username) {
        this.id = id;
        this.userNumber = userNumber;
        this.userName = username;
    }

    public User(int StudentNumber, String username) {
        this.userNumber = StudentNumber;
        this.userName = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(final int userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userNumber=" + userNumber +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final User user = (User) o;
        return userNumber == user.userNumber && Objects.equals(id, user.id) && Objects.equals(userName,
                user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userNumber, userName);
    }
}
