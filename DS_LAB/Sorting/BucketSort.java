import java.util.Arrays;

public class BucketSort {
    public static void bucketSort(float[] arr, int n) {
        if (n <= 0) 
            return;

        float[][] buckets = new float[n][n];
        int[] bucketSizes = new int[n]; 

        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]); 
            buckets[bucketIndex][bucketSizes[bucketIndex]++] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            if (bucketSizes[i] > 0) {
                Arrays.sort(buckets[i], 0, bucketSizes[i]); 
            }
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < bucketSizes[i]; j++) {
                arr[index++] = buckets[i][j];
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.53f, 0.12f, 0.85f, 0.34f, 0.64f, 0.25f};
        int n = arr.length;

        bucketSort(arr, n);

        System.out.println("Sorted array: ");
        for (float elem : arr) {
            System.out.print(elem + " ");
        }
    }
}
