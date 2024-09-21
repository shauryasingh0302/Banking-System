import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean f = true;
        while (f) {
            System.out.println("Select an option to start:\n1-Create Account\n2-Use Account\n3-Update Account\n4-Delete Account\n5.Exit");
            int inputChoice = scanner.nextInt();
            switch (inputChoice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.println("Create a password: ");
                    String password = scanner.nextLine();
                    Bank.createAccount(name, password);
                    break;

                case 2:
                    System.out.println("Enter Account ID");
                    int x = scanner.nextInt();
                    scanner.nextLine();
                    Bank account2 = Bank.getAccount(x);
                    System.out.println("Hello " + account2.getName() + " please enter Password to proceed:");
                    String pass2 = scanner.nextLine();
                    if (account2.authenticate(pass2)) {
                        Bank.menu(account2);
                    } else {
                        System.out.println("Incorrect Account Id or Password\n Please try again!!");
                    }
                    break;
                case 3:
                    System.out.println("Enter Account ID to update details:");
                    int y = scanner.nextInt();
                    scanner.nextLine();
                    Bank account3 = Bank.getAccount(y);
                    System.out.println("Hello " + account3.getName() + " please enter Password to proceed:");
                    String pass3 = scanner.nextLine();
                    if (account3.authenticate(pass3)) {
                        System.out.println("Enter New Name:\nLeave Empty to skip");
                        String a = scanner.nextLine();
                        if (!a.equals("")) {
                            Bank.update(account3, a);
                            System.out.println("Name updated Successfully!!");
                        }
                    } else {
                        System.out.println("Incorrect Account Id or Password\n Please try again!!");
                    }
                    break;
                case 4:
                    System.out.println("Enter Account ID to be deleted:");
                    int input4 = scanner.nextInt();
                    scanner.nextLine();
                    Bank account4 = Bank.getAccount(input4);
                    System.out.println("Hello " + account4.getName() + " please enter Password to proceed:");
                    String pass4 = scanner.nextLine();
                    if (account4.authenticate(pass4)) {
                        Bank.delete(input4);
                    } else {
                        System.out.println("Incorrect Account Id or Password\n Please try again!!");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");

                    f = false;
                    break;
                default:
                    System.out.println("Invalid Choice!!");

            }
        }

    }
}
