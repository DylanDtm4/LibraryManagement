import java.util.*;
public class Library {
    private Map<String, Person> mapPeople;
    private ArrayList<Book> listBooks;
    private ArrayList<Book> listCheckedOutBooks;

    public Library() {
        this.mapPeople = null;
        this.listBooks = null;
        this.listCheckedOutBooks = null;
    }

    public Library(Map<String, Person> mapPeople, ArrayList<Book> listBooks, ArrayList<Book> listCheckedOutBooks) {
        this.mapPeople = mapPeople;
        this.listBooks = listBooks;
        this.listCheckedOutBooks = listCheckedOutBooks;
    }

    public void addPerson(String username, Person person) {
        mapPeople.put(username, person);
    }

    public void removePerson(String username) {
        mapPeople.remove(username);
    }

    public void addBook(Book book) {
        listBooks.add(book);
    }
    
    public void removeBook(Book book) {
        listBooks.remove(book);
    }

    public void addCheckedOutBook(Book book) {
        listCheckedOutBooks.add(book);
    }
    
    public void removeCheckedOutBook(Book book) {
        listCheckedOutBooks.remove(book);
    }
    
    public Map<String, Person> getMapPeople() {
        return mapPeople;
    }

    public ArrayList<Book> getListBooks() {
        return listBooks;
    }

    public ArrayList<Book> getListCheckedOutBooks() {
        return listCheckedOutBooks;
    }     

    public void setListBooks(ArrayList<Book> listBooks) {
        this.listBooks = listBooks;
    }

    public void setListCheckedOutBooks(ArrayList<Book> listCheckedOutBooks) {
        this.listCheckedOutBooks = listCheckedOutBooks;
    }

    public void setMapPeople(Map<String, Person> mapPeople) {
        this.mapPeople = mapPeople;
    }
}
