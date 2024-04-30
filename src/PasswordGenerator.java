import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]?";

    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();
        System.out.print("Include symbols? (true/false): ");
        boolean includeSymbols = scanner.nextBoolean();
        System.out.print("Include numbers? (true/false): ");
        boolean includeNumbers = scanner.nextBoolean();
        System.out.print("Include only characters? (true/false): ");
        boolean onlyCharacters = scanner.nextBoolean();

        scanner.close();

        System.out.println("Your random password is: " + generateRandomPassword(length, includeSymbols, includeNumbers, onlyCharacters));
    }

    public static String generateRandomPassword(int length, boolean includeSymbols, boolean includeNumbers, boolean onlyCharacters) {
        String str = CHAR_LOWER + CHAR_UPPER;
        if (includeSymbols && !onlyCharacters) {
            str += OTHER_CHAR;
        }
        if (includeNumbers && !onlyCharacters) {
            str += NUMBER;
        }

        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int rndCharAt = random.nextInt(str.length());
            char rndChar = str.charAt(rndCharAt);
            sb.append(rndChar);
        }

        return sb.toString();
    }
}
