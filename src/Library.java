import java.util.*;
public class Library {
    public ArrayList<Clerk> listClerks;
    public ArrayList<Librarian> listLibrarians;
    public ArrayList<Book> listBooks;

    public Library() {
        this.listClerks = null;
        this.listLibrarians = null;
        this.listBooks = null;
    }

    public Library(ArrayList<Clerk> listClerks, ArrayList<Librarian> listLibrarians, ArrayList<Book> listBooks) {
        this.listClerks = listClerks;
        this.listLibrarians = listLibrarians;
        this.listBooks = listBooks;
    }

    public void addClerk(Clerk clerk) {
        listClerks.add(clerk);
    }

    public void addLibrarian(Librarian librarian) {
        listLibrarians.add(librarian);
    }

    public void addBook(Book book) {
        listBooks.add(book);
    }

    public void removeClerk(Clerk clerk) {
        listClerks.remove(clerk);
    }

    public void removeLibrarian(Librarian librarian) {
        listLibrarians.remove(librarian);
    }

    public void removeBook(Book book) {
        listBooks.remove(book);
    }
}
