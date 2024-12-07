import java.util.Scanner;

public class Task1_ConcatenateLines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            StringBuilder result = new StringBuilder();
            while (true) {
                String line = sc.nextLine();
                if (line.startsWith(".......")) {
                    break; // Para quando encontrar a linha que começa com "......."
                }
                if (result.length() > 0) {
                    result.append(" "); // Adiciona um espaço entre as linhas
                }
                result.append(line); // Concatena a linha
            }
            System.out.println(result.toString());
        }
    }
}
