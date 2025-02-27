import java.time.Instant;
import java.util.Date;

public class _208_Date_Config {
    public static void main(String[] args) {
        // Correct way to parse ISO-8601 string
        Instant instant = Instant.parse("2025-01-28T11:07:00Z"); // Ensure 'Z' for UTC
        Date date = Date.from(instant);

        System.out.println("Current Instant: " + Instant.now());
        System.out.println("Current Date: " + new Date());
        System.out.println("Parsed Date as Instant: " + date.toInstant());
    }
}
