import java.util.*;
// Case 8, 11 not done
public class Admin extends Person {
    private static int nextId = 1;

    public Admin(String firstName, String lastName, String address, String phoneNumber, String username, String passwordHash, Role role) {
        super(firstName, lastName, address, phoneNumber, username, passwordHash, role);
    }

    public Admin() {
    }

    public int printAdminMenu(Scanner scnr) {
        System.out.println("Following functionalities are available:\n");
        System.out.println("1- View Book");
        System.out.println("2- View All Books");
        System.out.println("3- View All Checked Out Books");
        System.out.println("4- Checkout Book");
        System.out.println("5- Return Book");
        System.out.println("6- Return All Books");
        System.out.println("7- Add New Book");
        System.out.println("8- Edit Book Information");
        System.out.println("9- Delete Book");
        System.out.println("10- Create User Account");
        System.out.println("11- Reset User Password");
        System.out.println("12- Create Clerk Account");
        System.out.println("13- Create Librarian Account");
        System.out.println("14- Create Admin Account");
        System.out.println("15- View All Users, Clerks, and Librarians");
        System.out.println("16- Logout");   
        System.out.println("-----------------------------------------\n");
        System.out.println("Enter choice: ");
        int adminChoice = scnr.nextInt();
        return adminChoice;
    }

    public int handleAdminChoice(Admin admin, HashMap<String, Person> people, Library myLibrary, Scanner scnr, int adminChoice) {
        BookInfo bookInfo;
        int count;

        switch(adminChoice) {
            case 1 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tView Book");
                System.out.println("-----------------------------------------");
                boolean isFound = false;
                int bookID = getInputID(scnr);
                ArrayList<Book> listBooks = myLibrary.getListBooks();
                for (Book book : listBooks) {
                    if (book.getID() == bookID) {
                        book.toString();
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    System.out.println("Error, no book with this ID.");
                }
                break;
            }
            case 2 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tView All Books");
                System.out.println("-----------------------------------------");
                count = 1;
                for (Book book: myLibrary.getListBooks()) {
                    System.out.println(count + ". " + book.toString());
                    count++;
                }
                break;
            }
            case 3 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tView All Checked Out Books");
                System.out.println("-----------------------------------------");
                count = 1;
                for (Book book: myLibrary.getListCheckedOutBooks()) {
                    System.out.println(count + ". " + book.issuedPrint());
                    count++;
                }
                break;
            }
            case 4 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tCheckout Book");
                System.out.println("-----------------------------------------");
                boolean isFound = false;
                boolean isCheckedOut;
                int bookID = getInputID(scnr);
                ArrayList<Book> listBooks = myLibrary.getListBooks();
                for (Book book : listBooks) {
                    if (book.getID() == bookID) {
                        isCheckedOut = book.isCheckedOut();
                        if (isCheckedOut) {
                            System.out.println("Error, book is currently checked out.");
                        }
                        else {
                            book.setCheckedOut(true);
                            book.setCheckedOutBy(admin.getUsername());
                        }
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    System.out.println("Error, no book with this ID.");
                }
                break;
            }
            case 5 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tReturn Book");
                System.out.println("-----------------------------------------");
                boolean isFound = false;
                boolean isCheckedOut;
                int bookID = getInputID(scnr);
                ArrayList<Book> listBooks = myLibrary.getListBooks();
                for (Book book : listBooks) {
                    if (book.getID() == bookID) {
                        isCheckedOut = book.isCheckedOut();
                        if (isCheckedOut) {
                            book.setCheckedOut(false);
                            book.setCheckedOutBy(null);
                        }
                        else {
                            System.out.println("Error, this book is not checked out by you.");
                        }
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    System.out.println("Error, no book with this ID.");
                }
                break;
            }
            case 6 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tReturn All Books");
                System.out.println("-----------------------------------------");
                ArrayList<Book> listCheckedOutBooks = myLibrary.getListCheckedOutBooks();
                for (Book book : listCheckedOutBooks) {
                    book.setCheckedOut(false);
                    book.setCheckedOutBy(null);
                }
                System.out.println("All of your checked out books have been returned.");
                break;
            }
            case 7 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tAdd New Book");
                System.out.println("-----------------------------------------");
                bookInfo = BookInfo.getBookInfo(scnr);
                Book newBook = new Book(nextId++, bookInfo, 0, null, false, "");
                myLibrary.addBook(newBook);
                break;
            }
            case 8 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tEdit Book Information");
                System.out.println("-----------------------------------------");
            }
            case 9 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tDelete Book");
                System.out.println("-----------------------------------------");
                boolean isFound = false;
                boolean isCheckedOut;
                int bookID = getInputID(scnr);
                ArrayList<Book> listBooks = myLibrary.getListBooks();
                ArrayList<Book> listCheckedOutBooks = myLibrary.getListCheckedOutBooks();                
                for (Book book : listBooks) {
                    if (book.getID() == bookID) {
                        isCheckedOut = book.isCheckedOut();
                        if (isCheckedOut) {
                            System.out.println("Error, this book is currently checked out.");
                        }
                        else {
                            listBooks.remove(book);
                            listCheckedOutBooks.remove(book);
                        }
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    System.out.println("Error, no book with this ID.");
                }
                break;
            }
            case 10 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tCreate User Account");
                System.out.println("-----------------------------------------");
                User newUser = User.createUser(people, scnr); 
                people.put(newUser.getUsername(), newUser);
                myLibrary.setMapPeople(people);
                break;
            }
            case 11 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tReset User Password");
                System.out.println("-----------------------------------------");
                String loginInfo[] = getUserPass(people, scnr);
                if (login(loginInfo[0], loginInfo[1])) {
                    System.out.print("Enter new password: ");
                    String newPassword = scnr.next();
                    String newPasswordHash = BCrypt.hashpw(newPassword, BCrypt.gensalt());
                    Person.setPasswordHash(newPassword);
                }
            }
            case 12 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tCreate Clerk Account");
                System.out.println("-----------------------------------------");
                Clerk newClerk = Clerk.createClerk(people, scnr); 
                people.put(newClerk.getUsername(), newClerk);
                myLibrary.setMapPeople(people);
                break;
            }
            case 13 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tCreate Librarian Account");
                System.out.println("-----------------------------------------");
                Librarian newLibrarian = Librarian.createLibrarian(people, scnr);
                people.put(newLibrarian.getUsername(), newLibrarian);
                myLibrary.setMapPeople(people);
                break;
            }
            case 14 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("\t\tCreate Admin Account");
                System.out.println("-----------------------------------------");
                Admin newAdmin = Admin.createAdmin(people, scnr);
                people.put(newAdmin.getUsername(), newAdmin);
                myLibrary.setMapPeople(people);
                break;
            }
            case 15 -> {
                System.out.println("-----------------------------------------"); // 41 -s
                System.out.println("View All Users, Clerks, and Librarians");
                System.out.println("-----------------------------------------");
                for (String key : people.keySet()) {
                    System.out.println(people.get(key).toString());
                }
            }
            case 16 -> {
                return -1;
            }
            default -> System.err.println("Invalid value detected. Please try again.");
        }
        return 0;    
    }

    public int getInputID(Scanner scnr) {
        int bookID;
        System.out.print("Enter book id: ");
        while (true) {
            try {
                bookID = scnr.nextInt();
                break;
            } catch (Exception e) {
                System.err.println("Invalid value detected. Please try again.");                    
            }
        }
        return bookID;
    }

    public static Admin createAdmin(HashMap<String, Person> people, Scanner scnr) {
        Person newAdminBase = Person.createAccount(people, scnr, Role.ADMIN);
        return new Admin(
            newAdminBase.getFirstName(),
            newAdminBase.getLastName(),
            newAdminBase.getAddress(),
            newAdminBase.getPhoneNumber(),
            newAdminBase.getUsername(),
            newAdminBase.getPasswordHash(),
            Role.ADMIN
        );
    }
}
