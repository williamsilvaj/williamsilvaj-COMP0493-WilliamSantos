import java.util.Scanner;

public class Task6_CountLastLineCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            if (line.startsWith(".......")) {
                line = sc.nextLine(); // Lê a última linha
                System.out.println(line.length()); // Imprime o número de caracteres
                break;
            }
        }
    }
}
