import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task5_MostFrequentWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String T = sc.nextLine().toLowerCase();
        String[] tokens = T.split("[ .]+"); // Tokeniza pela quebra de espaço ou ponto

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : tokens) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        String mostFrequentWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }

        System.out.println(mostFrequentWord);
    }
}
