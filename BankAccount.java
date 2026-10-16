package ATMInterface;


import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;
    private final List<Transaction> history = new ArrayList<>();

    public BankAccount(double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException(
                    "Opening balance cannot be negative.");
        }
        balance = openingBalance;
        history.add(new Transaction(
                "OPENING", openingBalance, "Account opened"));
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            return false;
        }

        balance += amount;
        history.add(new Transaction("DEPOSIT", amount,
                "Cash deposited"));
        return true;
    }

    public boolean withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0
                || amount > balance) {
            return false;
        }

        balance -= amount;
        history.add(new Transaction("WITHDRAW", amount,
                "Cash withdrawn"));
        return true;
    }

    public boolean transfer(double amount, String recipient) {
        if (!Double.isFinite(amount) || amount <= 0
                || amount > balance || recipient == null
                || recipient.trim().isEmpty()) {
            return false;
        }

        balance -= amount;
        history.add(new Transaction("TRANSFER", amount,
                "Transfer to " + recipient));
        return true;
    }

    public void showHistory() {
        System.out.println("\n--- Transaction History ---");

        if (history.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        for (Transaction transaction : history) {
            transaction.display();
        }
    }
}
