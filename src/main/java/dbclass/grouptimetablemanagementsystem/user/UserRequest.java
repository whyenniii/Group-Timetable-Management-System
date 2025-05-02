package dbclass.grouptimetablemanagementsystem.user;

public class UserRequest {
    private int userNumber;
    private String userName;

    public UserRequest(final int userNumber, final String userName) {
        this.userNumber = userNumber;
        this.userName = userName;
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
}
