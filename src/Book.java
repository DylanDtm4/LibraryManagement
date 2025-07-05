public class Book {
    public int id;
    public String title;
    public String author;
    public String genre;
    public int numPages;
    public double rating;

    public Book() {
        this.id = 0;
        this.title = "";
        this.author = "";
        this.genre = "";
        this.numPages = 0;
        this.rating = 0;
    }

    public Book(int id, String title, String author, String genre, int numPages, double rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.numPages = numPages;
        this.rating = rating;
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
}
