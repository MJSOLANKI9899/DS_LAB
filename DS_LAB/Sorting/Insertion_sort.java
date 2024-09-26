package Lab_19;

public class Insertion_sort {
    public static void main(String[] args) {
        int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        for (int i = 0; i < a.length - 1; i++) {
            int j = i;
            int temp = a[i + 1];
            while (j >= 0 && a[j] >= temp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;

        }
        System.out.println("Done!");
        System.out.println("Arry sorted;");
        for (int i : a) {
            System.out.println(i);
        }
    }
}
