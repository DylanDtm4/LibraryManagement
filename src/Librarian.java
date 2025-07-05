public class Librarian {
    public int id;
    public String firstName;
    public String lastName;
    private String address;
    public String phoneNumber;
    private double salary;

    public Librarian() {
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.phoneNumber = "";
        this.salary = 0;
    }

    public Librarian(int id, String firstName, String lastName, String address, String phoneNumber, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public String getAddress() {
        return this.address;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
