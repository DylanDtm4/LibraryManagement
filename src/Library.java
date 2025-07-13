import java.util.*;
public class Library {
    private Map<String, Clerk> mapClerks;
    private Map<String, Librarian> mapLibrarians;
    private Map<String, User> mapUsers;
    private ArrayList<Book> listBooks;
    private ArrayList<Book> listCheckedOutBooks;

    public Library() {
        this.mapClerks = null;
        this.mapLibrarians = null;
        this.listBooks = null;
    }

    public Library(Map<String, Clerk> mapClerks, Map<String, Librarian> mapLibrarians, Map<String, User> mapUsers, ArrayList<Book> listBooks, ArrayList<Book> listCheckedOutBooks) {
        this.mapClerks = mapClerks;
        this.mapLibrarians = mapLibrarians;
        this.mapUsers = mapUsers;
        this.listBooks = listBooks;
        this.listCheckedOutBooks = listCheckedOutBooks;
    }

    public Map<String, Clerk> getMapClerks() {
        return mapClerks;
    }

    public Map<String, Librarian> getMapLibrarians() {
        return mapLibrarians;
    }

    public Map<String, User> getMapUsers() {
        return mapUsers;
    }

    public ArrayList<Book> getListBooks() {
        return listBooks;
    }

    public ArrayList<Book> getListCheckedOutBooks() {
        return listCheckedOutBooks;
    }
            
    public void addClerk(String fullName, Clerk clerk) {
        mapClerks.put(fullName, clerk);
    }

    public void addLibrarian(String fullName, Librarian librarian) {
        mapLibrarians.put(fullName, librarian);
    }

    public void addUser(String fullName, User user) {
        mapUsers.put(fullName, user);
    }

    public void addBook(Book book) {
        listBooks.add(book);
    }

    public void removeClerk(String fullName, Clerk clerk) {
        mapClerks.remove(fullName, clerk);
    }

    public void removeLibrarian(String fullName,Librarian librarian) {
        mapLibrarians.remove(fullName, librarian);
    }

    public void removeUser(String fullName, User user) {
        mapUsers.remove(fullName, user);
    }

    public void removeBook(Book book) {
        listBooks.remove(book);
    }

    public void setMapClerks(Map<String, Clerk> mapClerks) {
        this.mapClerks = mapClerks;
    }

    public void setMapLibrarians(Map<String, Librarian> mapLibrarians) {
        this.mapLibrarians = mapLibrarians;
    }

    public void setMapUsers(Map<String, User> mapUsers) {
        this.mapUsers = mapUsers;
    }

    public void setListBooks(ArrayList<Book> listBooks) {
        this.listBooks = listBooks;
    }

    public void setListCheckedOutBooks(ArrayList<Book> listCheckedOutBooks) {
        this.listCheckedOutBooks = listCheckedOutBooks;
    }

    
}
