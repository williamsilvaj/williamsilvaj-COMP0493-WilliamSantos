import java.util.*;

public class LinearSortingAlgorithms {

    // Counting Sort - Funciona apenas para números inteiros não negativos
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        int[] count = new int[max + 1];

        for (int num : arr) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        List<Float>[] buckets = new List[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (float num : arr) {
            int bucketIndex = (int) (num * n);
            buckets[bucketIndex].add(num);
        }

        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[index++] = num;
            }
        }
    }

    // Radix Sort - Funciona para inteiros positivos 
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int num : arr) {
            count[(num / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
}
