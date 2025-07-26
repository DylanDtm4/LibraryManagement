import java.util.*;

public class Librarian extends Person {
    private double salary;

    public Librarian(String firstName, String lastName, String address, String phoneNumber, String username, String passwordHash, double salary, Role role) {
        super(firstName, lastName, address, phoneNumber, username, passwordHash, role);
        this.salary = salary;
    }

    public Librarian() {
        this.salary = 0;
    }

    public static Librarian createLibrarian(HashMap<String, Person> people, Scanner scnr) {
        Person newLibrarianBase = Person.createAccount(people, scnr, Role.LIBRARIAN);
        System.out.print("Enter salary: ");
        double inputSalary = scnr.nextDouble();
        scnr.nextLine();        
        return new Librarian(
            newLibrarianBase.getFirstName(),
            newLibrarianBase.getLastName(),
            newLibrarianBase.getAddress(),
            newLibrarianBase.getPhoneNumber(),
            newLibrarianBase.getUsername(),
            newLibrarianBase.getPasswordHash(),
            inputSalary,
            Role.LIBRARIAN
        );
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int printLibrarianMenu(Scanner scnr) {
        System.out.println("Following functionalities are available:\n");
        System.out.println("1- View Book");
        System.out.println("2- View All Books");
        System.out.println("3- View All Checked out Books");
        System.out.println("4- Checkout Book");
        System.out.println("5- Return Book");
        System.out.println("6- Return All Books");
        System.out.println("7- Add New Book");
        System.out.println("8- Edit Book Information");
        System.out.println("9- Delete Book");
        System.out.println("10- Create User Account");
        System.out.println("11- Reset User Password");
        System.out.println("12- Create Clerk Account");
        System.out.println("13- View All Users, Clerks, and Librarians");
        System.out.println("14- Logout");   
        System.out.println("-----------------------------------------\n");
        System.out.println("Enter choice: ");
        int librarianChoice = scnr.nextInt();
        return librarianChoice;
    }
}
