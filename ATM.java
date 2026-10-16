package ATMInterface;


import java.util.Scanner;

public class ATM {
    private final BankAccount account;
    private final Scanner scanner;

    public ATM(BankAccount account, Scanner scanner) {
        this.account = account;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.printf("Balance: Rs. %.2f%n",
                            account.getBalance());
                    break;

                case "2":
                    processDeposit();
                    break;

                case "3":
                    processWithdrawal();
                    break;

                case "4":
                    processTransfer();
                    break;

                case "5":
                    account.showHistory();
                    break;

                case "6":
                    System.out.println("Thank you for using the ATM.");
                    return;

                default:
                    System.out.println(
                            "Invalid choice. Please select 1 to 6.");
            }
        }
    }

    private double readAmount() {
        System.out.print("Enter amount: ");
        String input = scanner.nextLine().trim();

        try {
            double amount = Double.parseDouble(input);
            if (!Double.isFinite(amount) || amount <= 0) {
                System.out.println(
                        "Amount must be a positive number.");
                return -1;
            }
            return amount;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount.");
            return -1;
        }
    }

    private void processDeposit() {
        double amount = readAmount();
        if (amount > 0 && account.deposit(amount)) {
            System.out.println("Deposit successful.");
        }
    }

    private void processWithdrawal() {
        double amount = readAmount();
        if (amount <= 0) {
            return;
        }

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void processTransfer() {
        System.out.print("Enter recipient name or account number: ");
        String recipient = scanner.nextLine().trim();

        if (recipient.isEmpty()) {
            System.out.println("Recipient cannot be empty.");
            return;
        }

        double amount = readAmount();
        if (amount <= 0) {
            return;
        }

        if (account.transfer(amount, recipient)) {
            System.out.println("Transfer successful to " + recipient);
        } else {
            System.out.println("Transfer failed. Check your balance.");
        }
    }
}
