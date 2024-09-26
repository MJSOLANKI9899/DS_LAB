public class Demo_redix {
    public static void main(String[] args) {
        int[] arr = {4,1,3,5,6,3,5,3,2,1,7};
        Demo_redix a = new Demo_redix();
        a.radixSort(arr,arr.length);
    }

    void radixSort(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) if (arr[i] > max) max = arr[i];
    
        for (int place = 1; max / place > 0; place *= 10)
            countSort(arr, n, place);
    }
    
    void countSort(int arr[], int n, int place) {
        int[] output = new int[n];
        int count[] = {0};
    
        for (int i = 0; i < n; i++) 
            count[(arr[i] / place) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--)
            output[--count[(arr[i] / place) %10]] = arr[i];

        for (int i = 0; i < n; i++) 
            arr[i] = output[i];

    }
    

}
