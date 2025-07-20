import java.time.LocalDate;
import java.util.*;
public class User extends Person{
    private ArrayList<Book> checkedOutBooks;

    public User(String firstName, String lastName, String address, String phoneNumber, String username, String passwordHash, Role role, ArrayList<Book> checkedOutBooks) {
        super(firstName, lastName, address, phoneNumber, username, passwordHash, role);
        this.checkedOutBooks = checkedOutBooks;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public void setCheckedOutBooks(ArrayList<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public int printUserMenu(Scanner scnr) {
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

    public int handleUserChoice(User user, Library myLibrary, Scanner scnr, int userChoice) {
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
}
