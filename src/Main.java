import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        HashMap<String, Person> people = new HashMap<>();
        ArrayList<Book> listBooks = new ArrayList<>();
        ArrayList<Book> listCheckedOutBooks = new ArrayList<>();
        Library myLibrary = new Library(people, listBooks, listCheckedOutBooks);
        User user = new User();
        Admin admin = new Admin();
        Librarian librarian = new Librarian();
        Clerk clerk = new Clerk();
        int startChoice = 0;
        int userChoice = 0;
        int adminChoice = 0;
        boolean adminLogin = false;
        boolean userLogin = false;
        String username = "";
        String password = "";
        Person userInfo;
        System.out.println("-----------------------------------------"); // 41 -s
        System.out.println("  Welcome to Library Management System");
        System.out.println("-----------------------------------------");
        while (startChoice != 5) {
            startChoice = printStartMenu(scnr);
            switch(startChoice) {
                case 1 -> {
                    User existingUser = null;
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tEnter your credentials");
                    System.out.println("-----------------------------------------");
                    System.out.print("Username: ");
                    username = scnr.next();
                    System.out.print("Password: ");
                    password = scnr.next();

                    Person person = people.get(username);
                    if (person instanceof User user1) {
                        existingUser = user1;
                    } else {
                        System.out.println("This person is not a User.");
                    }

                    if (existingUser != null && BCrypt.checkpw(password, existingUser.getPasswordHash())) {
                        userLogin = true;
                        user = existingUser;                       
                        System.out.println("Login successful");
                    }
                    else {
                        System.out.println("Login failed.");
                    }

                    while (userLogin) {
                        System.out.println();
                        userChoice = user.printUserMenu(scnr);
                        if (user.handleUserChoice(user, myLibrary, scnr, userChoice) == -1) {
                            userLogin = false;
                            user = null;
                        }
                    }
                    break;
                }
                case 2 -> {
                    Admin existingAdmin = null;
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tEnter your credentials");
                    System.out.println("-----------------------------------------");
                    System.out.print("Username: ");
                    username = scnr.next();
                    System.out.print("Password: ");
                    password = scnr.next();

                    Person person = people.get(username);
                    if (person instanceof Admin admin1) {
                        existingAdmin = admin1;
                    } else {
                        System.out.println("This person is not a User.");
                    }
                    if (existingAdmin != null && BCrypt.checkpw(password, existingAdmin.getPasswordHash())) {
                        adminLogin = true;
                        admin = existingAdmin;
                        System.out.println("Login successful");
                    }
                    else {
                        System.out.println("Login failed.");
                    }
                    while (adminLogin == true) {
                        System.out.println();
                        adminChoice = admin.printAdminMenu(scnr);
                        if (admin.handleAdminChoice(people, myLibrary, scnr, adminChoice) == -1) {
                            adminLogin = false;
                            admin = null;
                        }
                    }
                    break;
                }
                case 3 -> {
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tCreate A User Account");
                    System.out.println("-----------------------------------------");
                    User newUser = (User) Person.createAccount(people, scnr, Role.USER);
                    people.put(newUser.getUsername(), newUser);
                    myLibrary.setMapPeople(people);
                    System.out.println("User Account Created!");
                    break;
                }
                case 4 -> {
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tCreate A Admin Account");
                    System.out.println("-----------------------------------------");
                    Admin newAdmin = (Admin) Person.createAccount(people, scnr, Role.ADMIN);
                    people.put(newAdmin.getUsername(), newAdmin);
                    myLibrary.setMapPeople(people);
                    System.out.println("Admin Account Created!");
                    break;
                }
                case 5 -> {
                    break;
                }
                default -> System.out.println("Invalid value detected. Please try again.");
            }
            
        }
        
        
        System.out.println("Application Closed");
    }

    public static int printStartMenu(Scanner scnr) {
        System.out.println();
        System.out.println("Following functionalities are available:\n");
        System.out.println("1- Login As User");
        System.out.println("2- Login As Admin");
        System.out.println("3- Create A User Account");
        System.out.println("4- Create A Admin Account");
        System.out.println("5- Exit");
        System.out.println("-----------------------------------------\n");
        System.out.println("Enter choice: ");
        int startChoice = scnr.nextInt();
        return startChoice;
    }
}   


