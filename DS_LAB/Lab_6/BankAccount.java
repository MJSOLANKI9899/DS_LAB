public class BankAccount {
    private String accountNumber;
    private double balance;
    private String accountHolder;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }

    // Method to check balance
    public double getBalance() {
        return balance;
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for account holder
    public String getAccountHolder() {
        return accountHolder;
    }

    public static void main(String[] args) {
        // Create an array of bank accounts
        BankAccount[] accounts = new BankAccount[3];

        // Create and add accounts to the array
        accounts[0] = new BankAccount("1234567890", "John Doe", 500.0);
        accounts[1] = new BankAccount("0987654321", "Jane Smith", 1000.0);
        accounts[2] = new BankAccount("1112223334", "Alice Johnson", 750.0);

        // Example operations
        accounts[0].deposit(200.0);
        accounts[1].withdraw(150.0);
        System.out.println("Balance of account " + accounts[0].getAccountNumber() + ": " + accounts[0].getBalance());
        System.out.println("Balance of account " + accounts[1].getAccountNumber() + ": " + accounts[1].getBalance());
    }
}
