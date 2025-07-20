public class Librarian extends Person {
    private double salary;

    public Librarian(String firstName, String lastName, String address, String phoneNumber, String username, String passwordHash, Role role, double salary) {
        super(firstName, lastName, address, phoneNumber, username, passwordHash, role);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
