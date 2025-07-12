import java.util.*;
public class Library {
    public Map<String, Clerk> mapClerks;
    public Map<String, Librarian> mapLibrarians;
    public ArrayList<Book> listBooks;
    private ArrayList<Book> listCheckedOutBooks;

    public Library() {
        this.mapClerks = null;
        this.mapLibrarians = null;
        this.listBooks = null;
    }

    public Library(Map<String, Clerk> mapClerks, Map<String, Librarian> mapLibrarians, ArrayList<Book> listBooks, ArrayList<Book> listCheckedOutBooks) {
        this.mapClerks = mapClerks;
        this.mapLibrarians = mapLibrarians;
        this.listBooks = listBooks;
        this.listCheckedOutBooks = listCheckedOutBooks;
    }

    public ArrayList<Book> getListCheckedOutBooks() {
        return this.listCheckedOutBooks;
    }
            
    public void addClerk(String fullName, Clerk clerk) {
        mapClerks.put(fullName, clerk);
    }

    public void addLibrarian(String fullName, Librarian librarian) {
        mapLibrarians.put(fullName, librarian);
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

    public void removeBook(Book book) {
        listBooks.remove(book);
    }

    public void setMapClerks(Map<String, Clerk> mapClerks) {
        this.mapClerks = mapClerks;
    }

    public void setMapLibrarians(Map<String, Librarian> mapLibrarians) {
        this.mapLibrarians = mapLibrarians;
    }

    public void setListBooks(ArrayList<Book> listBooks) {
        this.listBooks = listBooks;
    }

    public void setListCheckedOutBooks(ArrayList<Book> listCheckedOutBooks) {
        this.listCheckedOutBooks = listCheckedOutBooks;
    }
}
