import java.util.Scanner;

// BankAccount Class
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited %.2f. Current balance: %.2f\n", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
            return false;
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
            return false;
        } else {
            balance -= amount;
            System.out.printf("Successfully withdrew %.2f. Current balance: %.2f\n", amount, balance);
            return true;
        }
    }

    // Check balance method
    public double getBalance() {
        return balance;
    }
}

// ATM Class
class ATM {
    private BankAccount account;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Display menu
    public void displayMenu() {
        System.out.println("\nWelcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    // Execute selected option
    public void executeOption(int option) {
        Scanner sc = new Scanner(System.in);

        switch (option) {
            case 1: // Check balance
                System.out.printf("Your current balance is: %.2f\n", account.getBalance());
                break;

            case 2: // Deposit
                System.out.print("Enter the amount to deposit: ");
                double depositAmount = sc.nextDouble();
                account.deposit(depositAmount);
                break;

            case 3: // Withdraw
                System.out.print("Enter the amount to withdraw: ");
                double withdrawAmount = sc.nextDouble();
                account.withdraw(withdrawAmount);
                break;

            case 4: // Exit
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

// Main Class
public class ATMInterface {
    public static void main(String[] args) {
        // Initialize a bank account with an initial balance
        BankAccount account = new BankAccount(1000.0);

        // Initialize the ATM interface
        ATM atm = new ATM(account);

        Scanner sc = new Scanner(System.in);

        // Continuously display the menu and process user input
        while (true) {
            atm.displayMenu();
            int option = sc.nextInt();
            atm.executeOption(option);
        }
    }
}
