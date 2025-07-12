import java.util.*;
public class User {
    public int id;
    public String firstName;
    public String lastName;
    private String address;
    private String phoneNumber;
    private ArrayList<Book> checkedOutBooks;
    public String username; 

    public User() {
        id = 0;
        firstName = "";
        lastName = "";
        address = "";
        phoneNumber = "";
        checkedOutBooks = null;
        username = "";
    }

    public User(int id, String firstName, String lastName, String address, String phoneNumber, ArrayList<Book> checkedOutBooks, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.checkedOutBooks = checkedOutBooks;
        this.username = username;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return this.checkedOutBooks;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCheckedOutBooks(ArrayList<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
