package ATMInterface;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final String type;
    private final double amount;
    private final LocalDateTime dateTime;
    private final String details;

    public Transaction(String type, double amount, String details) {
        this.type = type;
        this.amount = amount;
        this.details = details;
        this.dateTime = LocalDateTime.now();
    }

    public void display() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.printf("%s | %-12s | Rs. %.2f | %s%n",
                dateTime.format(formatter), type, amount, details);
    }
}
