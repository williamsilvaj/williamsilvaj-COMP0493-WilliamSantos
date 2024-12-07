import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2_FindSubstringIndices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String T = sc.nextLine();
        String P = sc.nextLine();

        List<Integer> indices = new ArrayList<>();

        int index = T.indexOf(P);
        while (index != -1) {
            indices.add(index);
            index = T.indexOf(P, index + 1);
        }

        if (indices.isEmpty()) {
            System.out.println("-1");
        } else {
            for (int idx : indices) {
                System.out.print(idx + " ");
            }
            System.out.println();
        }
    }
}
