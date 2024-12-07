import java.util.Scanner;

public class Task3_AnalyzeAndLowercase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String T = sc.nextLine();
        int digits = 0, vowels = 0, consonants = 0;

        T = T.toLowerCase();
        for (char c : T.toCharArray()) {
            if (Character.isDigit(c)) {
                digits++;
            } else if (isVowel(c)) {
                vowels++;
            } else if (Character.isAlphabetic(c)) {
                consonants++;
            }
        }

        System.out.println("Digits: " + digits);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}
