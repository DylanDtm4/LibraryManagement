import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        int startChoice = 0;
        int userChoice = 0;
        int adminChoice = 0;
        boolean adminLogin = false;
        boolean userLogin = false;
        System.out.println("-----------------------------------------"); // 41 -s
        System.out.println("  Welcome to Library Management System");
        System.out.println("-----------------------------------------");
        while (startChoice != 3) {
            startChoice = printStartMenu(scnr);
            switch(startChoice) {
                case 1:
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tEnter your credentials");
                    System.out.println("-----------------------------------------");
                    // Check credentials
                    userLogin = true;
                    while (userLogin == true) {
                        userChoice = printUserMenu(scnr);
                        if (handleUserChoice(userChoice) == -1) {
                            userLogin = false;
                        }
                    }
                    break;
                case 2:
                    System.out.println("-----------------------------------------"); // 41 -s
                    System.out.println("\tEnter your credentials");
                    System.out.println("-----------------------------------------");
                    // Check credentials
                    adminLogin = true;
                    while (adminLogin == true) {
                        adminChoice = printAdminMenu(scnr);
                        if (handleAdminChoice(adminChoice) == -1) {
                            adminLogin = false;
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    break;
            }
            
        }
        
        
        System.out.println("Application Closed");
    }

    public static int printStartMenu(Scanner scnr) {
        System.out.println("Following functionalities are available:\n");
        System.out.println("1- Login");
        System.out.println("2- Administrative Functions");
        System.out.println("3- Exit");
        System.out.println("-----------------------------------------\n");
        System.out.println("Enter choice: ");
        int startChoice = scnr.nextInt();
        return startChoice;
    }

    public static int printUserMenu(Scanner scnr) {
        System.out.println("Following functionalities are available:\n");
        System.out.println("1- View Book");
        System.out.println("2- View All Books");
        System.out.println("3- View All Checked out Books");
        System.out.println("4- Checkout Book");
        System.out.println("5- Return Book");
        System.out.println("6- Return All Books");
        System.out.println("7- Logout");
        System.out.println("-----------------------------------------\n");
        System.out.println("Enter choice: ");
        int userChoice = scnr.nextInt();
        return userChoice;
    }

    public static int printAdminMenu(Scanner scnr) {
        System.out.println("Following functionalities are available:\n");
        System.out.println("1- Add Clerk");
        System.out.println("2- Add Librarian");
        System.out.println("3- Add Book");
        System.out.println("4- View Issued Books History");
        System.out.println("5- View All Books in Library");
        System.out.println("6- Logout");
        System.out.println("-----------------------------------------\n");
        System.out.println("Enter choice: ");
        int adminChoice = scnr.nextInt();
        return adminChoice;
    }

    public static int handleUserChoice(int userChoice) {
        switch(userChoice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                return -1;
            default: 
                System.out.println("Invalid value detected. Please try again.");
                break;
        }
        return 0;
    }

    public static int handleAdminChoice(int adminChoice) {
        switch(adminChoice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                return -1;
            default: 
                System.out.println("Invalid value detected. Please try again.");
                break;
        }
        return 0;    
    }
}   


