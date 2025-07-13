import java.util.*;
public class User {
    private UserInfo userInfo;
    private ArrayList<Book> checkedOutBooks;
    private String username; 

    public User() {
        userInfo = null;
        checkedOutBooks = null;
        username = "";
    }

    public User(UserInfo userInfo, ArrayList<Book> checkedOutBooks, String username) {
        this.userInfo = userInfo;
        this.checkedOutBooks = checkedOutBooks;
        this.username = username;
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

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setCheckedOutBooks(ArrayList<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
