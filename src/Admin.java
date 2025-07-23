import java.util.*;

public class Admin extends Person {
    private static int nextId = 1;

    public Admin(String firstName, String lastName, String address, String phoneNumber, String username, String passwordHash, Role role) {
        super(firstName, lastName, address, phoneNumber, username, passwordHash, role);
    }

    public Admin() {
    }

    public int printAdminMenu(Scanner scnr) {
        System.out.println("Following functionalities are available:\n");
        System.out.println("1- Add Clerk");
        System.out.println("2- Add Librarian");
        System.out.println("3- Add Book");                              // remove and give only to librarian
        System.out.println("4- View All Issued Books in Library");      // remove and give only to librarian
        System.out.println("5- View All Books in Library");             // remove and give only to librarian & create a set pay for employee ID
        System.out.println("6- Logout");
        System.out.println("-----------------------------------------\n");
        System.out.println("Enter choice: ");
        int adminChoice = scnr.nextInt();
        return adminChoice;
    }


    public int handleAdminChoice(HashMap<String, Person> people, Library myLibrary, Scanner scnr, int adminChoice) {
        BookInfo bookInfo;
        int count;

        switch(adminChoice) {
            case 1 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tAdd a Clerk");
                System.out.println("-----------------------------------------");
                Clerk newClerk = Clerk.createClerk(people, scnr); 
                people.put(newClerk.getUsername(), newClerk);
                myLibrary.setMapPeople(people);
                break;
            }
            case 2 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tAdd a Librarian");
                System.out.println("-----------------------------------------");
                Librarian newLibrarian = Librarian.createLibrarian(people, scnr);
                people.put(newLibrarian.getUsername(), newLibrarian);
                myLibrary.setMapPeople(people);
                break;
            }
            case 3 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tAdd a Book");
                System.out.println("-----------------------------------------");
                bookInfo = BookInfo.getBookInfo(scnr);
                Book newBook = new Book(nextId++, bookInfo, 0, null, false, "");
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
