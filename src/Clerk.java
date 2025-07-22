import java.util.*;

public class Clerk extends Person {
    private double salary;

    public Clerk(String firstName, String lastName, String address, String phoneNumber, String username, String passwordHash, double salary, Role role) {
        super(firstName, lastName, address, phoneNumber, username, passwordHash, role);
        this.salary = salary;
    }

    public static Clerk createClerk(HashMap<String, Person> people, Scanner scnr) {
        Person newClerkBase = Person.createAccount(people, scnr, Role.CLERK);
        System.out.print("Enter salary: ");
        double inputSalary = scnr.nextDouble();
        scnr.nextLine();        
        return new Clerk(
            newClerkBase.getFirstName(),
            newClerkBase.getLastName(),
            newClerkBase.getAddress(),
            newClerkBase.getPhoneNumber(),
            newClerkBase.getUsername(),
            newClerkBase.getPasswordHash(),
            inputSalary,
            Role.CLERK
        );
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
