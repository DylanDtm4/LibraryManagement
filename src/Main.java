import java.time.LocalDate;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        Library myLibrary = new Library();
        User user = new User();
        int startChoice = 0;
        int userChoice = 0;
        int adminChoice = 0;
        boolean adminLogin = false;
        boolean userLogin = false;
        String username = "";
        String password = "";
        System.out.println("-----------------------------------------"); // 41 -s
        System.out.println("  Welcome to Library Management System");
        System.out.println("-----------------------------------------");
        while (startChoice != 3) {
            startChoice = printStartMenu(scnr);
            switch(startChoice) {
                case 1:
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tEnter your credentials");
                    System.out.println("-----------------------------------------");
                    // Check credentials (currently hardcoded)
                    System.out.print("Username: ");
                    username = scnr.next();
                    System.out.print("Password: ");
                    password = scnr.next();
                    System.out.println(username);
                    System.out.println(password);
                    if (username.equals("user") && password.equals("password")) {
                        userLogin = true;
                    } else {
                        System.out.println("Login Failed.");
                    }
                    System.out.println();
                    while (userLogin == true) {
                        userChoice = printUserMenu(scnr);
                        if (handleUserChoice(user, myLibrary, scnr, userChoice) == -1) {
                            userLogin = false;
                        }
                    }
                    break;
                case 2:
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tEnter your credentials");
                    System.out.println("-----------------------------------------");
                    // Check credentials (currently hardcoded)
                    System.out.print("Username: ");
                    username = scnr.next();
                    System.out.print("Password: ");
                    password = scnr.next();
                    System.out.println(username);
                    System.out.println(password);
                    if (username.equals("admin") && password.equals("password")) {
                        adminLogin = true;
                    } else {
                        System.out.println("Login Failed.");
                    }
                    System.out.println();
                    while (adminLogin == true) {
                        adminChoice = printAdminMenu(scnr);
                        if (handleAdminChoice(myLibrary, scnr, adminChoice) == -1) {
                            adminLogin = false;
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid value detected. Please try again.");
                    break;
            }
            
        }
        
        
        System.out.println("Application Closed");
    }

    public static int printStartMenu(Scanner scnr) {
        System.out.println("Following functionalities are available:\n");
        System.out.println("1- Login");
        System.out.println("2- Administrative Functions");
        System.out.println("3- Exit");
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
        ArrayList<Book> checkedOutBooks;
        switch(userChoice) {
            case 1:
                bookID = getBookID(scnr);
                for (Book book : myLibrary.listBooks) {
                    if (book.id == bookID) {
                        System.out.println(book.toString());
                        break;
                    }
                }
                System.out.println("No book found with id of " + bookID);
                break;
            case 2:
                count = 1;
                for (Book book: myLibrary.listBooks) {
                    System.out.println(count + ". " + book.toString());
                    count++;
                }
                break;
            case 3:
                count = 1;
                checkedOutBooks = user.getCheckedOutBooks();
                for (Book book: checkedOutBooks) {
                    System.out.println(count + ". " + book.toString());
                    count++;
                }
                break;
            case 4:
                bookID = getBookID(scnr);
                LocalDate dueDate = LocalDate.now().plusDays(30);
                for (Book book : myLibrary.listBooks) {
                    if (book.id == bookID) {
                        book.setdueDate(dueDate);
                        book.setCheckedOut(true);
                        book.setCheckedOutBy(user.username);
                        checkedOutBooks = user.getCheckedOutBooks();
                        checkedOutBooks.add(book);
                        user.setCheckedOutBooks(checkedOutBooks);
                        break;
                    }
                }
                System.out.println("No book found with id of " + bookID);
                break;
            case 5:
                bookID = getBookID(scnr);
                checkedOutBooks = user.getCheckedOutBooks();
                for (Book book: checkedOutBooks) {
                    if (book.id == bookID) {
                        book.setdueDate(null);
                        book.setCheckedOut(false);
                        book.setCheckedOutBy("");
                        checkedOutBooks.remove(book);
                        user.setCheckedOutBooks(checkedOutBooks);
                        break;
                    }
                }
                System.out.println("No book found with id of " + bookID);
                break;
            case 6:
                checkedOutBooks = user.getCheckedOutBooks();
                for (Book book: checkedOutBooks) {
                    book.setCheckedOut(false);
                    book.setCheckedOutBy("");
                    checkedOutBooks.remove(book);
                    user.setCheckedOutBooks(checkedOutBooks);
                }
                break;
            case 7:
                return -1;
            default: 
                System.out.println("Invalid value detected. Please try again.");
                break;
        }
        return 0;
    }

    public static int printAdminMenu(Scanner scnr) {
        System.out.println("Following functionalities are available:\n");
        System.out.println("1- Add Clerk");
        System.out.println("2- Add Librarian");
        System.out.println("3- Add Book");
        System.out.println("4- View Issued Books History");
        System.out.println("5- View All Books in Library");
        System.out.println("6- Logout");
        System.out.println("-----------------------------------------\n");
        System.out.println("Enter choice: ");
        int adminChoice = scnr.nextInt();
        return adminChoice;
    }


    public static int handleAdminChoice(Library myLibrary, Scanner scnr, int adminChoice) {
        WorkerInfo workerInfo;
        String fullName;
        Map<String, Clerk> mapClerks;
        Map<String, Librarian> mapLibrarians;

        switch(adminChoice) {
            case 1:
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tAdd a Clerk");
                System.out.println("-----------------------------------------");
                workerInfo = getWorkerInfo(scnr);
                Clerk newClerk = new Clerk(workerInfo);
                mapClerks = myLibrary.mapClerks;
                fullName = workerInfo.firstName + " " + workerInfo.lastName;
                mapClerks.put(fullName, newClerk);
                break;
            case 2:
            System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tAdd a Librarian");
                System.out.println("-----------------------------------------");
                workerInfo = getWorkerInfo(scnr);
                Librarian newLibrarian = new Librarian(workerInfo);
                mapLibrarians = myLibrary.mapLibrarians;
                fullName = workerInfo.firstName + " " + workerInfo.lastName;
                mapLibrarians.put(fullName, newLibrarian);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                return -1;
            default: 
                System.out.println("Invalid value detected. Please try again.");
                break;
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
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a whole number");
                scnr.nextLine();
            }
        }
        return (bookID > 0) ? bookID : -1;
    }

    // need to add validation tests
    public static WorkerInfo getWorkerInfo(Scanner scnr) {
        System.out.print("Enter first name: ");
        String firstName = scnr.next();
        System.out.print("Enter last name: ");
        String lastName = scnr.next();
        System.out.print("Enter address: ");
        String address = scnr.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scnr.next();
        System.out.print("Enter salary: ");
        double salary = scnr.nextDouble();
        WorkerInfo workerInfo = new WorkerInfo(firstName, lastName, address, phoneNumber, salary);
        return workerInfo;
    }
}   


