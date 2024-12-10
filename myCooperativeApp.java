import java.util.ArrayList;
import java.util.Scanner;

// CooperativeApp class to manage the cooperative system

    public class myCooperativeApp {
    private ArrayList<Account> accounts = new ArrayList<>();
    private int nextAccountId = 1;
    private static final double MAX_DEPOSIT = 50000.0; // Maximum allowed deposit
    private static final double MAX_WITHDRAWAL = 5000.0; // Maximum allowed withdrawal

    public void registerAccount(String name, int membershipLength) {
        accounts.add(new Account(nextAccountId++, name, membershipLength));
        System.out.println("Account registered successfully.");
    }

    public Account findAccount(int id) {
        for (Account account : accounts) {
            if (account.getAccountId() == id) {
                return account;
            }
        }
        return null;
    }

    public void checkBalance(int id) {
        Account account = findAccount(id);
        if (account != null) {
            System.out.println("Balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void deposit(int id, double amount) {
        if (amount > MAX_DEPOSIT) {
            System.out.println("Deposit exceeds the maximum allowed amount of $" + MAX_DEPOSIT);
            return;
        }

        Account account = findAccount(id);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(int id, double amount) {
        if (amount > MAX_WITHDRAWAL) {
            System.out.println("Withdrawal exceeds the maximum allowed amount of $" + MAX_WITHDRAWAL);
            return;
        }

        Account account = findAccount(id);
        if (account != null) {
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient funds or exceeds allowable withdrawal limit.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void accountOverview(int id) {
        Account account = findAccount(id);
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void main(String[] args) {
        myCooperativeApp app = new myCooperativeApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Cooperative Application ---");
            System.out.println("1. Register Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Funds");
            System.out.println("4. Withdraw Funds");
            System.out.println("5. Account Overview");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter membership length (in years): ");
                    int membershipLength = scanner.nextInt();
                    app.registerAccount(name, membershipLength);
                    break;
                case 2:
                    System.out.print("Enter account ID: ");
                    int idCheck = scanner.nextInt();
                    app.checkBalance(idCheck);
                    break;
                case 3:
                    System.out.print("Enter account ID: ");
                    int idDeposit = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double deposit = scanner.nextDouble();
                    app.deposit(idDeposit, deposit);
                    break;
                case 4:
                    System.out.print("Enter account ID: ");
                    int idWithdraw = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawal = scanner.nextDouble();
                    app.withdraw(idWithdraw, withdrawal);
                    break;
                case 5:
                    System.out.print("Enter account ID: ");
                    int idOverview = scanner.nextInt();
                    app.accountOverview(idOverview);
                    break;
                case 6:
                    System.out.println("Exiting application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
