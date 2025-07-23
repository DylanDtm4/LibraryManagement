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
        int librarianChoice = 0;
        int clerkChoice = 0;
        boolean adminLogin = false;
        boolean userLogin = false;
        boolean librarianLogin = false;
        boolean clerkLogin = false;
        String username;
        String password;
        System.out.println("-----------------------------------------"); // 41 -s
        System.out.println("  Welcome to Library Management System");
        System.out.println("-----------------------------------------");
        while (startChoice != 7) {
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

                    if (existingUser != null && existingUser.login(username, password)) {
                        userLogin = true;
                        user = existingUser;                       
                        System.out.println("Login successful");
                    }
                    else {
                        System.out.println("Login failed.");
                    }

                    while (userLogin) {
                        System.out.println();
                        if (user != null) {
                            userChoice = user.printUserMenu(scnr);
                            if (user.handleUserChoice(user, myLibrary, scnr, userChoice) == -1) {
                                userLogin = false;
                                user = null;
                            }
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
                        System.out.println("This person is not a Admin.");
                    }
                    if (existingAdmin != null && existingAdmin.login(username, password)) {
                        adminLogin = true;
                        admin = existingAdmin;
                        System.out.println("Login successful");
                    }
                    else {
                        System.out.println("Login failed.");
                    }
                    while (adminLogin == true) {
                        System.out.println();
                        if (admin != null) {
                            adminChoice = admin.printAdminMenu(scnr);
                            if (admin.handleAdminChoice(people, myLibrary, scnr, adminChoice) == -1) {
                                adminLogin = false;
                                admin = null;
                            }
                        }
                    }
                    break;
                }
                case 3 -> {
                    Librarian existingLibrarian = null;
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tEnter your credentials");
                    System.out.println("-----------------------------------------");
                    System.out.print("Username: ");
                    username = scnr.next();
                    System.out.print("Password: ");
                    password = scnr.next();

                    Person person = people.get(username);
                    if (person instanceof Librarian librarian1) {
                        existingLibrarian = librarian1;
                    } else {
                        System.out.println("This person is not a Librarian.");
                    }

                    if (existingLibrarian != null && existingLibrarian.login(username, password)) {
                        librarianLogin = true;
                        librarian = existingLibrarian;                       
                        System.out.println("Login successful");
                    }
                    else {
                        System.out.println("Login failed.");
                    }

                    while (librarianLogin) {
                        System.out.println();
                        if (librarian != null) {
                            librarianChoice = librarian.printLibrarianMenu(scnr);
                            if (librarian.handleLibrarianChoice(librarian, myLibrary, scnr, librarianChoice) == -1) {
                                librarianLogin = false;
                                librarian = null;
                            }
                        }
                    }
                    break;
                }
                case 4 -> {
                    Clerk existingClerk = null;
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tEnter your credentials");
                    System.out.println("-----------------------------------------");
                    System.out.print("Username: ");
                    username = scnr.next();
                    System.out.print("Password: ");
                    password = scnr.next();

                    Person person = people.get(username);
                    if (person instanceof Clerk clerk1) {
                        existingClerk = clerk1;
                    } else {
                        System.out.println("This person is not a Clerk.");
                    }
                    if (existingClerk != null && existingClerk.login(username, password)) {
                        clerkLogin = true;
                        clerk = existingClerk;
                        System.out.println("Login successful");
                    }
                    else {
                        System.out.println("Login failed.");
                    }
                    while (clerkLogin == true) {
                        System.out.println();
                        if (clerk != null) {
                            clerkChoice = clerk.printClerkMenu(scnr);
                            if (clerk.handleClerkChoice(people, myLibrary, scnr, clerkChoice) == -1) {
                                clerkLogin = false;
                                clerk = null;
                            }
                        }
                    }
                    break;
                }
                case 5 -> {
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tCreate A User Account");
                    System.out.println("-----------------------------------------");
                    User newUser = (User) Person.createAccount(people, scnr, Role.USER);
                    people.put(newUser.getUsername(), newUser);
                    myLibrary.setMapPeople(people);
                    System.out.println("User Account Created!");
                    break;
                }
                case 6 -> {
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tCreate A Admin Account");
                    System.out.println("-----------------------------------------");
                    Admin newAdmin = (Admin) Person.createAccount(people, scnr, Role.ADMIN);
                    people.put(newAdmin.getUsername(), newAdmin);
                    myLibrary.setMapPeople(people);
                    System.out.println("Admin Account Created!");
                    break;
                }
                case 7 -> {
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
        System.out.println("3- Login As Librarian");
        System.out.println("4- Login As Clerk");
        System.out.println("5- Create A User Account");
        System.out.println("6- Create A Admin Account");
        System.out.println("7- Exit");
        System.out.println("-----------------------------------------\n");
        System.out.println("Enter choice: ");
        int startChoice = scnr.nextInt();
        return startChoice;
    }
}   


