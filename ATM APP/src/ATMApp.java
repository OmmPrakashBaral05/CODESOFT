import java.util.Scanner;

// Main class
public class ATMApp {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000.0); // initial Balance
        ATM atm = new ATM(myAccount);
        atm.run();
    }
}

// BankAccount class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ ₹" + amount + " deposited successfully.");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("✅ ₹" + amount + " withdrawn successfully.");
        }
    }

    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }
}

// ATM class
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showMenu();
            System.out.print("👉 Enter your choice (1-4): ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                handleWithdraw();
            } else if (input.equals("2")) {
                handleDeposit();
            } else if (input.equals("3")) {
                account.checkBalance();
            } else if (input.equals("4")) {
                System.out.println("👋 Exiting... Thank you!");
                break;
            } else {
                System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    private void handleWithdraw() {
        System.out.print("💸 Enter amount to withdraw: ₹");
        double amount = getValidAmount();
        account.withdraw(amount);
    }

    private void handleDeposit() {
        System.out.print("💰 Enter amount to deposit: ₹");
        double amount = getValidAmount();
        account.deposit(amount);
    }

    private double getValidAmount() {
        while (true) {
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                return amount;
            } catch (NumberFormatException e) {
                System.out.print("❌ Invalid input. Please enter a valid number: ₹");
            }
        }
    }
}


