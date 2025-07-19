import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        Map<String, Clerk> clerks = new HashMap<>();
        Map<String, Librarian> librarians = new HashMap<>();
        Map<String, User> users = new HashMap<>();
        Map<String, Admin> admins = new HashMap<>();
        ArrayList<Book> listBooks = new ArrayList<>();
        ArrayList<Book> listCheckedOutBooks = new ArrayList<>();
        Library myLibrary = new Library(clerks, librarians, users, admins, listBooks, listCheckedOutBooks);
        User user = new User();
        Admin admin = new Admin();
        int startChoice = 0;
        int userChoice = 0;
        int adminChoice = 0;
        boolean adminLogin = false;
        boolean userLogin = false;
        String username = "";
        String password = "";
        UserInfo userInfo;
        System.out.println("-----------------------------------------"); // 41 -s
        System.out.println("  Welcome to Library Management System");
        System.out.println("-----------------------------------------");
        while (startChoice != 5) {
            startChoice = printStartMenu(scnr);
            switch(startChoice) {
                case 1 -> {
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tEnter your credentials");
                    System.out.println("-----------------------------------------");
                    System.out.print("Username: ");
                    username = scnr.next();
                    System.out.print("Password: ");
                    password = scnr.next();
                    User existingUser = users.get(username);
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
                        userChoice = printUserMenu(scnr);
                        if (handleUserChoice(user, myLibrary, scnr, userChoice) == -1) {
                            userLogin = false;
                            user = null;
                        }
                    }
                    break;
                }
                case 2 -> {
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tEnter your credentials");
                    System.out.println("-----------------------------------------");
                    System.out.print("Username: ");
                    username = scnr.next();
                    System.out.print("Password: ");
                    password = scnr.next();
                    Admin existingAdmin = admins.get(username);
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
                        adminChoice = printAdminMenu(scnr);
                        if (handleAdminChoice(myLibrary, scnr, adminChoice) == -1) {
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
                    while(true) {
                        try {
                            System.out.println("Enter a username: ");
                            username = scnr.next();
                            if (!users.containsKey(username)) { break; }
                            else { System.out.println("Username taken. Please try again."); }
                        } catch (Exception e) {
                            System.out.println("Invalid input detected. Please try again.");
                        }
                    }
                    System.out.println("Enter a password: ");
                    password = scnr.next();
                    String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
                    userInfo = getUserInfo(scnr);
                    User newUser = new User(userInfo, new ArrayList<>(), username, passwordHash);
                    users.put(username, newUser);
                    System.out.println("User Account Created!");
                    break;
                }
                case 4 -> {
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tCreate A Admin Account");
                    System.out.println("-----------------------------------------");
                    while(true) {
                        try {
                            System.out.println("Enter a username: ");
                            username = scnr.next();
                            if (!admins.containsKey(username)) { break; }
                            else { System.out.println("Username taken. Please try again."); }
                        } catch (Exception e) {
                            System.out.println("Invalid input detected. Please try again.");
                        }
                    }
                    System.out.println("Enter a password: ");
                    password = scnr.next();
                    String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
                    Admin newAdmin = new Admin(username, passwordHash);
                    admins.put(username, newAdmin);
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

    public static int printUserMenu(Scanner scnr) {
        System.out.println("Following functionalities are available:\n");
        System.out.println("1- View Book");
        System.out.println("2- View All Books");
        System.out.println("3- View All Checked out Books");
        System.out.println("4- Checkout Book");
        System.out.println("5- Return Book");
        System.out.println("6- Return All Books");
        System.out.println("7- Logout");
        System.out.println("-----------------------------------------\n");
        System.out.println("Enter choice: ");
        int userChoice = scnr.nextInt();
        return userChoice;
    }

    public static int handleUserChoice(User user, Library myLibrary, Scanner scnr, int userChoice) {
        int count;
        int bookID;
        boolean bookFound;
        boolean isCheckedOut;
        ArrayList<Book> checkedOutBooks;
        switch(userChoice) {
            case 1 -> {
                bookFound = false;
                bookID = getBookID(scnr);
                for (Book book : myLibrary.getListBooks()) {
                    if (book.getId() == bookID) {
                        System.out.println(book.toString());
                        bookFound = true;
                        break;
                    }
                }
                if (!bookFound) {
                    System.out.println("No book found with id of " + bookID);
                }
                break;
            }
            case 2 -> {
                count = 1;
                for (Book book: myLibrary.getListBooks()) {
                    System.out.println(count + ". " + book.toString());
                    count++;
                }
                break;
            }
            case 3 -> {
                count = 1;
                checkedOutBooks = user.getCheckedOutBooks();
                for (Book book: checkedOutBooks) {
                    System.out.println(count + ". " + book.toString());
                    count++;
                }
                break;
            }
            case 4 -> {
                bookFound = false;
                isCheckedOut = false;
                bookID = getBookID(scnr);
                LocalDate dueDate = LocalDate.now().plusDays(30);
                for (Book book : myLibrary.getListBooks()) {
                    if (book.getId() == bookID && book.isCheckedOut() == true) isCheckedOut = true;
                    else if (book.getId() == bookID && book.isCheckedOut() == false) {
                        book.setDueDate(dueDate);
                        book.setCheckedOut(true);
                        book.setCheckedOutBy(user.getUsername());
                        checkedOutBooks = user.getCheckedOutBooks();
                        checkedOutBooks.add(book);
                        user.setCheckedOutBooks(checkedOutBooks);
                        bookFound = true;
                        break;
                    }
                }
                if (!bookFound) {
                    System.out.println("No book found with id of " + bookID);
                }
                if (isCheckedOut) {
                    System.out.println("This book is currently checked out.");
                }
                break;
            }
            case 5 -> {
                bookFound = false;
                bookID = getBookID(scnr);
                checkedOutBooks = user.getCheckedOutBooks();
                Iterator<Book> iter = checkedOutBooks.iterator();
                while (iter.hasNext()) {
                    Book book = iter.next();
                    if (book.getId() == bookID) {
                        book.setDueDate(null);
                        book.setCheckedOut(false);
                        book.setCheckedOutBy("");
                        iter.remove();
                        user.setCheckedOutBooks(checkedOutBooks);
                        bookFound = true;
                        break;
                    }
                }
                if (!bookFound) {
                    System.out.println("No book found with id of " + bookID);
                }
                break;
            }
            case 6 -> {
                checkedOutBooks = user.getCheckedOutBooks();
                for (Book book: checkedOutBooks) {
                    book.setCheckedOut(false);
                    book.setCheckedOutBy("");
                }
                checkedOutBooks.clear();
                user.setCheckedOutBooks(checkedOutBooks);
                break;
            }
            case 7 -> {
                return -1;
            }
            default -> System.out.println("Invalid value detected. Please try again.");
        }
        return 0;
    }

    public static int printAdminMenu(Scanner scnr) {
        System.out.println("Following functionalities are available:\n");
        System.out.println("1- Add Clerk");
        System.out.println("2- Add Librarian");
        System.out.println("3- Add Book");
        System.out.println("4- View All Issued Books in Library");
        System.out.println("5- View All Books in Library");
        System.out.println("6- Logout");
        System.out.println("-----------------------------------------\n");
        System.out.println("Enter choice: ");
        int adminChoice = scnr.nextInt();
        return adminChoice;
    }


    public static int handleAdminChoice(Library myLibrary, Scanner scnr, int adminChoice) {
        WorkerInfo workerInfo;
        BookInfo bookInfo;
        String fullName;
        Map<String, Clerk> mapClerks;
        Map<String, Librarian> mapLibrarians;
        int count;

        switch(adminChoice) {
            case 1 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tAdd a Clerk");
                System.out.println("-----------------------------------------");
                workerInfo = getWorkerInfo(scnr);
                Clerk newClerk = new Clerk(workerInfo);
                mapClerks = myLibrary.getMapClerks();
                fullName = workerInfo.getFirstName() + " " + workerInfo.getLastName();
                mapClerks.put(fullName, newClerk);
                break;
            }
            case 2 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tAdd a Librarian");
                System.out.println("-----------------------------------------");
                workerInfo = getWorkerInfo(scnr);
                Librarian newLibrarian = new Librarian(workerInfo);
                mapLibrarians = myLibrary.getMapLibrarians();
                fullName = workerInfo.getFirstName() + " " + workerInfo.getLastName();
                mapLibrarians.put(fullName, newLibrarian);
                break;
            }
            case 3 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tAdd a Book");
                System.out.println("-----------------------------------------");
                bookInfo = getBookInfo(scnr);
                Book newBook = new Book(0, bookInfo, 0, null, false, "");
                myLibrary.addBook(newBook);
                break;
            }
            case 4 -> {
                count = 1;
                for (Book book: myLibrary.getListCheckedOutBooks()) {
                    System.out.println(count + ". " + book.issuedPrint());
                    count++;
                }
                break;
            }
            case 5 -> {
                count = 1;
                for (Book book: myLibrary.getListBooks()) {
                    System.out.println(count + ". " + book.toString());
                    count++;
                }
                break;
            }
            case 6 -> {
                return -1;
            }
            default -> System.out.println("Invalid value detected. Please try again.");
        }
        return 0;    
    }

    public static int getBookID(Scanner scnr) {
        int bookID;
        while(true) {
            System.out.print("Enter book ID: ");
            try {
                bookID = scnr.nextInt();
                scnr.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number");
                scnr.nextLine();
            }
        }
        return (bookID > 0) ? bookID : -1;
    }

    public static UserInfo getUserInfo(Scanner scnr) {
        while (true) {
            try {
                scnr.nextLine();
                System.out.print("Enter first name: ");
                String firstName = scnr.next();
                System.out.print("Enter last name: ");
                String lastName = scnr.next();
                scnr.nextLine();
                System.out.print("Enter address: ");
                String address = scnr.nextLine();
                System.out.print("Enter phone number: ");
                String phoneNumber = scnr.next();
                scnr.nextLine();
                UserInfo userInfo = new UserInfo(firstName, lastName, address, phoneNumber);
                return userInfo;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input detected. Please try again.");
            }
        }
    }

    public static WorkerInfo getWorkerInfo(Scanner scnr) {
        while (true) {
            try {
                scnr.nextLine();
                System.out.print("Enter first name: ");
                String firstName = scnr.next();
                System.out.print("Enter last name: ");
                String lastName = scnr.next();
                scnr.nextLine();
                System.out.print("Enter address: ");
                String address = scnr.nextLine();
                System.out.print("Enter phone number: ");
                String phoneNumber = scnr.next();
                System.out.print("Enter salary: ");
                double salary = scnr.nextDouble();
                scnr.nextLine();
                WorkerInfo workerInfo = new WorkerInfo(firstName, lastName, address, phoneNumber, salary);
                return workerInfo;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input detected. Please try again.");
            }
        }
    }

    public static BookInfo getBookInfo(Scanner scnr) {
        while (true) {
            try {
                scnr.nextLine();
                System.out.print("Enter title: ");
                String title = scnr.nextLine();
                System.out.print("Enter author: ");
                String author = scnr.nextLine();
                System.out.print("Enter genre: ");
                String genre = scnr.nextLine();
                System.out.print("Enter number of pages: ");
                int numPages = scnr.nextInt();
                BookInfo bookInfo = new BookInfo(title, author, genre, numPages);
                return bookInfo;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input detected. Please try again.");
            }
        }
    }
}   


