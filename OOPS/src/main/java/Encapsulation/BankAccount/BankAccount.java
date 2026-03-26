package Encapsulation.BankAccount;

import java.util.*;

public class BankAccount {
    private final String owner;
    private double balance = 0.0;
    private final double overdraftLimit;
    private final List<Map<String,Object>> history = new ArrayList<>();
    private boolean frozen = false;

    public BankAccount(String owner, double overdraftLimit) {
        this.owner = owner;
        this.overdraftLimit = overdraftLimit;
    }

    private boolean checkFrozen() {
        if (frozen){
            System.out.println("Account frozen");
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        checkFrozen();
        if (amount <= 0){
            System.out.println("Positive only");
            return;
        }
        balance += amount;
        history.add(Map.of("type", "deposit", "amount", amount));
    }

    public void withdraw(double amount) {
        if(checkFrozen()) return;
        if (balance - amount < overdraftLimit){
//            throw new IllegalStateException("Exceeds overdraft limit");
            System.out.println("Insufficient funds");
            return;
        }
        balance -= amount;
        history.add(Map.of("type", "withdraw", "amount", amount));
    }

    public double getBalance() { return balance; }

    public List<?> getHistory() {
        return Collections.unmodifiableList(history); // read-only view
    }

    public void freeze() { frozen = true; }
}