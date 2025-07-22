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
}
