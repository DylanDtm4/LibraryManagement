import java.util.*;

public class Person {
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String phoneNumber;
    protected String username; 
    protected String passwordHash;
    protected Role role;

    public Person(String firstName, String lastName, String address, String phoneNumber, String username, String passwordHash, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public boolean login(String username, String passwordHash) {
        if (!this.username.equals(username)) {
            return false;
        }
        return BCrypt.checkpw(passwordHash, this.passwordHash);
    }

    public Person createAccount(HashMap<String, Person> people, Scanner scnr, Role role) {
        String[] accountInfo = getUserPass(people, scnr);
        String inputUsername = accountInfo[0];
        String inputPasswordHash = accountInfo[1];
        while (true) {
            try {
                scnr.nextLine();
                System.out.print("Enter first name: ");
                String inputFirstName = scnr.next();
                System.out.print("Enter last name: ");
                String inputLastName = scnr.next();
                scnr.nextLine();
                System.out.print("Enter address: ");
                String inputAddress = scnr.nextLine();
                System.out.print("Enter phone number: ");
                String inputPhoneNumber = scnr.next();
                scnr.nextLine();
                Person newPerson = new Person(inputFirstName, inputLastName, inputAddress, inputPhoneNumber, inputUsername, inputPasswordHash, role);
                return newPerson;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input detected. Please try again.");
            }
        }
    }

    public String[] getUserPass(HashMap<String, Person> people, Scanner scnr) {
        String inputUsername;
        while(true) {
            try {
                System.out.println("Enter a username: ");
                inputUsername = scnr.next();
                if (!people.containsKey(username)) { break; }
                else { System.out.println("Username taken. Please try again."); }
            } catch (Exception e) {
                System.out.println("Invalid input detected. Please try again.");
            }
        }
        System.out.println("Enter a password: ");
        String inputPassword = scnr.next();
        String inputPasswordHash = BCrypt.hashpw(inputPassword, BCrypt.gensalt());
        return new String[] { inputUsername, inputPasswordHash };
    }

    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
        
    public String getUsername() {
        return username;
    }
    
    public String getPasswordHash() {
        return passwordHash;
    }

    public Role getRole() {
        return role;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
