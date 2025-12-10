package oop.BankManagementsystem;

public class UserDetails {

    private static int userCount = 0;
    private int accNum;
    private String accHolder;
    private double balance;

    public UserDetails(String accHolder, double balance) {
        this.accNum = ++userCount;
        this.accHolder = accHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccHolder() {
        return accHolder;
    }

    public int getNumber() {
        return accNum;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
        } else {
            System.out.println("Insufficient / Invalid amount");
        }
    }
}
