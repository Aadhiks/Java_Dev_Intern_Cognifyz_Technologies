import java.security.SecureRandom;
import java.util.Scanner;

public class RandomPasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the desired length of the password: ");
        int passwordLength = scanner.nextInt();


        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");
   
        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("yes");


        String password = generateRandomPassword(passwordLength, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);


        System.out.println("Your random password is: " + password);


        scanner.close();
    }

    private static String generateRandomPassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecialChars) {
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

        StringBuilder validChars = new StringBuilder();

        if (includeLowercase) {
            validChars.append(lowercaseChars);
        }

        if (includeUppercase) {
            validChars.append(uppercaseChars);
        }

        if (includeNumbers) {
            validChars.append(numberChars);
        }

        if (includeSpecialChars) {
            validChars.append(specialChars);
        }

        if(validChars.length() == 0) {
           System.out.println("Please select at least one character type.");
           System.exit(1);
        }

        
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++ ) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }
}