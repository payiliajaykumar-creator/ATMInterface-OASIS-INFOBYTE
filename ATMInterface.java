package ATMInterface;


import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demo credentials for this educational project.
        String demoPin = "1234";

        BankAccount account = new BankAccount(5000.00);
        PinAuthenticator authenticator =
                new PinAuthenticator(demoPin);

        System.out.println("===== WELCOME TO JAVA ATM =====");

        if (authenticator.authenticate(scanner)) {
            ATM atm = new ATM(account, scanner);
            atm.start();
        }

        scanner.close();
    }
}
