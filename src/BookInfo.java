import java.util.InputMismatchException;
import java.util.Scanner;

public class BookInfo {
    private String title;
    private String author;
    private String genre;
    private int numPages;

    public BookInfo() {
        this.title = "";
        this.author = "";
        this.genre = "";
        this.numPages = 0;
    }
    public BookInfo(String title, String author, String genre, int numPages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.numPages = numPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public static BookInfo getBookInfo(Scanner scnr) {
        while (true) {
            try {
                scnr.nextLine();
                System.out.print("Enter title: ");
                String title = scnr.nextLine();
                System.out.print("Enter author: ");
                String author = scnr.nextLine();
                System.out.print("Enter genre: ");
                String genre = scnr.nextLine();
                System.out.print("Enter number of pages: ");
                int numPages = scnr.nextInt();
                BookInfo bookInfo = new BookInfo(title, author, genre, numPages);
                return bookInfo;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input detected. Please try again.");
            }
        }
    }
}
