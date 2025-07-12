import java.time.LocalDate;
import java.util.*;
public class Book {
    public int id;
    public String title;
    public String author;
    public String genre;
    public int numPages;
    public double rating;
    public LocalDate dueDate;
    public boolean checkedOut;
    private String checkedOutBy;

    public Book() {
        this.id = 0;
        this.title = "";
        this.author = "";
        this.genre = "";
        this.numPages = 0;
        this.rating = 0;
        this.dueDate = null;
        this.checkedOut = false;
        this.checkedOutBy = "";
    }

    public Book(int id, String title, String author, String genre, int numPages, double rating, LocalDate dueDate, boolean checkedOut, String checkedOutBy) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.numPages = numPages;
        this.rating = rating;
        this.dueDate = dueDate;
        this.checkedOut = checkedOut;
        this.checkedOutBy = checkedOutBy;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    
    public void setdueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public void setCheckedOutBy(String checkedOutBy) {
        this.checkedOutBy = checkedOutBy;
    }

    public String toString() {
        return title + " by " + author + " is a " + genre + " book and it has " + numPages + " and a rating of " + rating;
    }
}
