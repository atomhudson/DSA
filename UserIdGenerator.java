import java.util.UUID;

public class UserIdGenerator {
    public static String generateUserId() {
        String uuidPart = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8).toUpperCase();
        return "USR" + uuidPart;
    }

    public static void main(String[] args) {
        System.out.println(generateUserId());
    }
}

