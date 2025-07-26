import java.time.LocalDate;
import java.util.*;
public class User extends Person{
    private ArrayList<Book> checkedOutBooks;

    public User(String firstName, String lastName, String address, String phoneNumber, String username, String passwordHash, Role role, ArrayList<Book> checkedOutBooks) {
        super(firstName, lastName, address, phoneNumber, username, passwordHash, role);
        this.checkedOutBooks = checkedOutBooks;
    }

    public User() {
        this.checkedOutBooks = null;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public void setCheckedOutBooks(ArrayList<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public static User createUser(HashMap<String, Person> people, Scanner scnr) {
        Person newUserBase = Person.createAccount(people, scnr, Role.USER);
        return new User(
            newUserBase.getFirstName(),
            newUserBase.getLastName(),
            newUserBase.getAddress(),
            newUserBase.getPhoneNumber(),
            newUserBase.getUsername(),
            newUserBase.getPasswordHash(),
            Role.USER,
            new ArrayList<>()
        );
    }

    public int printUserMenu(Scanner scnr) {
        System.out.println("Following functionalities are available:\n");
        System.out.println("1- View Book");
        System.out.println("2- View All Books");
        System.out.println("3- View My Checked out Books");
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
        ArrayList<Book> choiceCheckedOutBooks;
        switch(userChoice) {
            case 1 -> {
                bookFound = false;
                bookID = Book.getBookID(scnr);
                for (Book book : myLibrary.getListBooks()) {
                    if (book.getID() == bookID) {
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
                choiceCheckedOutBooks = user.getCheckedOutBooks();
                for (Book book: choiceCheckedOutBooks) {
                    System.out.println(count + ". " + book.toString());
                    count++;
                }
                break;
            }
            case 4 -> {
                bookFound = false;
                isCheckedOut = false;
                bookID = Book.getBookID(scnr);
                LocalDate dueDate = LocalDate.now().plusDays(30);
                for (Book book : myLibrary.getListBooks()) {
                    if (book.getID() == bookID && book.isCheckedOut() == true) isCheckedOut = true;
                    else if (book.getID() == bookID && book.isCheckedOut() == false) {
                        book.setDueDate(dueDate);
                        book.setCheckedOut(true);
                        book.setCheckedOutBy(user.getUsername());
                        choiceCheckedOutBooks = user.getCheckedOutBooks();
                        choiceCheckedOutBooks.add(book);
                        user.setCheckedOutBooks(choiceCheckedOutBooks);
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
                bookID = Book.getBookID(scnr);
                choiceCheckedOutBooks = user.getCheckedOutBooks();
                Iterator<Book> iter = choiceCheckedOutBooks.iterator();
                while (iter.hasNext()) {
                    Book book = iter.next();
                    if (book.getID() == bookID) {
                        book.setDueDate(null);
                        book.setCheckedOut(false);
                        book.setCheckedOutBy("");
                        iter.remove();
                        user.setCheckedOutBooks(choiceCheckedOutBooks);
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
                choiceCheckedOutBooks = user.getCheckedOutBooks();
                for (Book book: choiceCheckedOutBooks) {
                    book.setCheckedOut(false);
                    book.setCheckedOutBy("");
                }
                choiceCheckedOutBooks.clear();
                user.setCheckedOutBooks(choiceCheckedOutBooks);
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
