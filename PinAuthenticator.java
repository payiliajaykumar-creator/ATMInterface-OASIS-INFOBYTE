package ATMInterface;


import java.util.Scanner;

public class PinAuthenticator {
    private final String correctPin;

    public PinAuthenticator(String correctPin) {
        if (correctPin == null || !correctPin.matches("\\d{4}")) {
            throw new IllegalArgumentException(
                    "PIN must contain exactly four digits.");
        }
        this.correctPin = correctPin;
    }

    public boolean authenticate(Scanner scanner) {
        for (int attempts = 1; attempts <= 3; attempts++) {
            System.out.print("Enter your 4-digit PIN: ");
            String enteredPin = scanner.nextLine().trim();

            if (enteredPin.equals(correctPin)) {
                System.out.println("PIN verified successfully.");
                return true;
            }

            System.out.println("Incorrect PIN. Attempts remaining: "
                    + (3 - attempts));
        }

        System.out.println("Maximum attempts reached. Access denied.");
        return false;
    }
}
