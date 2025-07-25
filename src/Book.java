import java.time.LocalDate;
import java.util.*;

public class Book {
    

    private int id;
    private BookInfo bookInfo;
    private double rating;
    private LocalDate dueDate;
    private boolean checkedOut;
    private String checkedOutBy;

    public Book() {
        this.id = 0;
        this.bookInfo = null;
        this.rating = 0;
        this.dueDate = null;
        this.checkedOut = false;
        this.checkedOutBy = "";
    }

    public Book(int id, BookInfo bookInfo, double rating, LocalDate dueDate, boolean checkedOut, String checkedOutBy) {
        this.id = id;
        this.bookInfo = bookInfo;
        this.rating = rating;
        this.dueDate = dueDate;
        this.checkedOut = checkedOut;
        this.checkedOutBy = checkedOutBy;
    }
    
    public int getID() {
        return id;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }
    
    public double getRating() {
        return rating;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public String getCheckedOutBy() {
        return checkedOutBy;
    }

    public void setId(int id) {
            this.id = id;
    }

    public void setBookInfo(BookInfo bookInfo) {
            this.bookInfo = bookInfo;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public void setCheckedOutBy(String checkedOutBy) {
        this.checkedOutBy = checkedOutBy;
    }

    public @Override String toString() {
        return String.format("%s by %s is a %s book and it has %d pages and a rating of %.1f. This book is currently %s checked out.",
                            bookInfo.getTitle(), bookInfo.getAuthor(), bookInfo.getGenre(), bookInfo.getNumPages(), rating, checkedOut ? "" : "not");
    }

    public String issuedPrint() {
        return String.format("%s is currently checked out by %s and it is due on %s", bookInfo.getTitle(), checkedOutBy, dueDate);
    }

    public static int getBookID(Scanner scnr) {
        int bookID;
        while(true) {
            System.out.print("Enter book ID: ");
            try {
                bookID = scnr.nextInt();
                scnr.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number");
                scnr.nextLine();
            }
        }
        return (bookID > 0) ? bookID : -1;
    }
}
