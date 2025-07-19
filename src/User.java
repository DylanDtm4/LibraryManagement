import java.util.*;
public class User {
    private UserInfo userInfo;
    private ArrayList<Book> checkedOutBooks;
    private String username; 
    private String passwordHash;

    public User() {
        userInfo = null;
        checkedOutBooks = null;
        username = "";
        passwordHash = "";
    }

    public User(UserInfo userInfo, ArrayList<Book> checkedOutBooks, String username, String passwordHash) {
        this.userInfo = userInfo;
        this.checkedOutBooks = checkedOutBooks;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setCheckedOutBooks(ArrayList<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
