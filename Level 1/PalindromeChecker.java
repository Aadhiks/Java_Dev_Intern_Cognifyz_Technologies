import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word or phrase: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The entered word or phrase is a palindrome.");
        } else {
            System.out.println("The entered word or phrase is not a palindrome.");
        }

        scanner.close();
    }


private static boolean isPalindrome(String str) {
    
    String cleanedString = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

    return cleanedString.equals(new StringBuilder(cleanedString).reverse().toString());
    }
}
