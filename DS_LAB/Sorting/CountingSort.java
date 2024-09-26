import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] arr) {
        int n = arr.length;

        int max = Arrays.stream(arr).max().getAsInt();

        int[] count = new int[max + 1];
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));

        countingSort(arr);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
}
