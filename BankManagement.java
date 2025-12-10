class UserDetails {   // Inner class should not use 'Class'

    private static int userCount = 0;   // static counter
    private int accNum;
    private String accHolder;
    private double balance;

    // Constructor
    UserDetails(String accHolder, double balance) {
        this.accNum = ++userCount;
        this.accHolder = accHolder;
        this.balance = balance;
    }

    // Get balance
    public double getBalance() {
        return balance;
    }

    // Get account holder
    public String getAccHolder() {
        return accHolder;
    }

    // Get account number
    public int getNumber() {
        return accNum;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Credited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Withdraw method (COMPLETED)
    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            this.balance -= amount;
            System.out.println("Debited: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }
}

public class BankManagement {

    public static void main(String[] args) {

        UserDetails user1 = new UserDetails("Karthik", 5000);

        System.out.println("Account Number: " + user1.getNumber());
        System.out.println("Account Holder: " + user1.getAccHolder());
        System.out.println("Balance: " + user1.getBalance());

        user1.deposit(2000);
        user1.withdraw(3000);
        user1.withdraw(6000);   // testing insufficient balance

        System.out.println("Final Balance: " + user1.getBalance());
    }
}
