import java.util.Map;
import java.util.Scanner;

public class Admin extends Person {
    public Admin(String firstName, String lastName, String address, String phoneNumber, String username, String passwordHash, Role role) {
        super(firstName, lastName, address, phoneNumber, username, passwordHash, role);
    }

    public int printAdminMenu(Scanner scnr) {
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


    public int handleAdminChoice(Library myLibrary, Scanner scnr, int adminChoice) {
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
}
