import java.util.*;

public class DivideAndConquerAlgorithms {

    // Binary Exponentiation - Calcula (base^exp) % mod em O(log n)
    public static long binaryExponentiation(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    // Merge Sort - O(n log n)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    // Inversion Index - Conta pares (i, j) onde i < j e arr[i] > arr[j]
    public static int countInversions(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    private static int mergeSortAndCount(int[] arr, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = mergeSortAndCount(arr, left, mid) + mergeSortAndCount(arr, mid + 1, right);
        count += mergeAndCount(arr, left, mid, right);
        return count;
    }

    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left, swaps = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                swaps += (mid + 1) - (left + i);
            }
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
        return swaps;
    }

    // Longest Common Prefix - Retorna o prefixo comum mais longo entre strings
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefixHelper(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefixHelper(String[] strs, int left, int right) {
        if (left == right) return strs[left];

        int mid = left + (right - left) / 2;
        String leftPrefix = longestCommonPrefixHelper(strs, left, mid);
        String rightPrefix = longestCommonPrefixHelper(strs, mid + 1, right);
        return commonPrefix(leftPrefix, rightPrefix);
    }

    private static String commonPrefix(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, minLength);
    }
}
