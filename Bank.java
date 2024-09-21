import java.util.ArrayList;
import java.util.Scanner;

class Bank {
    private static int id = 1;
    private String name;
    private String password;
    private int accountId;
    private int balance;
    private static ArrayList<Bank> accounts = new ArrayList<>();

    public Bank(String name, String password) {
        this.name = name;
        this.password = password;
        this.accountId = id++;
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public boolean authenticate(String pass) {
        return this.password.equals(pass);
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public static void createAccount(String name, String password) {
        Bank newAccount = new Bank(name, password);
        accounts.add(newAccount);
        System.out.println("Hello "+newAccount.getName()+"! Your account is successfully created!!\nYour Account ID is "+newAccount.getAccountId());
    }

    public static Bank getAccount(int id) {
        for (Bank account : accounts) {
            if (account.getAccountId() == id) {
                return account;
            }
        }
        return null;
    }

    public static void update(Bank account, String newName) {
        account.name = newName;
    }

    public static void delete(int delId) {
        Bank accDel = getAccount(delId);
        if (accDel != null) {
            accounts.remove(accDel);
            System.out.println("Dear "+accDel.getName()+" your account has been successfully deleted!!");
        }
    }

    public static void menu(Bank account) {
        Scanner scanner = new Scanner(System.in);
        boolean m = true;
        while(m){
        System.out.println("1. Transfer Money\n2. Deposit\n3. Withdraw\n4. Show Current Balance\n5. Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                scanner.nextLine();
                System.out.println("Enter Amount to transfer:");
                int amount = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Transfer to whom (Account Id)");
                int payeeId = scanner.nextInt();
                Bank payee = Bank.getAccount(payeeId);
                if (account.getBalance() > amount) {
                    account.withdraw(amount);
                    payee.deposit(amount);
                } else {
                    System.out.println("Insufficient Balance!!");
                }
                System.out.println("Transferred Successfully!!");
                System.out.println("Successful! Your current balance is Rs." + account.getBalance());
                break;
            case 2:
                System.out.println("Enter amount to deposit:");
                int depositAmount = scanner.nextInt();
                scanner.nextLine();
                account.deposit(depositAmount);
                System.out.println("Successful! Your current balance is Rs." + account.getBalance());
                break;
            case 3:
                System.out.println("Enter amount to withdraw:");
                int withdrawAmount = scanner.nextInt();
                scanner.nextLine();
                account.withdraw(withdrawAmount);
                System.out.println("Successful! Your current balance is Rs." + account.getBalance());
                break;
            case 4:
                System.out.println("Your current balance is Rs." + account.getBalance());
                break;
            case 5:
                System.out.println("Exiting to main menu...");
                m=false;
                break;
            default:
                System.out.println("Invalid Choice!!");
        }
      }
    }
}
