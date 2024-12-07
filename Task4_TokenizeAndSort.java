import java.util.Arrays;
import java.util.Scanner;

public class Task4_TokenizeAndSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String T = sc.nextLine().toLowerCase();
        String[] tokens = T.split("[ .]+"); // Tokeniza pela quebra de espaço ou ponto

        Arrays.sort(tokens); // Ordena lexicograficamente

        System.out.println(tokens[0]); // Imprime o menor token
    }
}
