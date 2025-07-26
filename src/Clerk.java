import java.util.*;

public class Clerk extends Person {
    private double salary;

    public Clerk(String firstName, String lastName, String address, String phoneNumber, String username, String passwordHash, double salary, Role role) {
        super(firstName, lastName, address, phoneNumber, username, passwordHash, role);
        this.salary = salary;
    }

    public Clerk() {
        this.salary = 0;
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

    public int printClerkMenu(Scanner scnr) {
        System.out.println("Following functionalities are available:\n");
        System.out.println("1- View Book");
        System.out.println("2- View All Books");
        System.out.println("3- View All Checked out Books");
        System.out.println("4- Checkout Book");
        System.out.println("5- Reshelf Books");
        System.out.println("6- Return All Books");
        System.out.println("7- Logout");
        System.out.println("-----------------------------------------\n");
        System.out.println("Enter choice: ");
        int clerkChoice = scnr.nextInt();
        return clerkChoice;
    }
}
