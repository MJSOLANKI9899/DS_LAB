import java.util.Scanner;

public class SortArry {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = { 1, 4, 7, 10, 13 };
        System.out.println("Enter no.");
        int i = sc.nextInt();
        sc.close();
        int[] b = new int[a.length + 1];
        int j = 0;
        int t = 0;

        for (t = 0; t < a.length; t++) {

            if (a[t] < i) {
                b[t] = a[t];
            } else if (a[t] > i || a[t] == i) {
                b[t] = i;
                j = t;
                break;
            }

        }
        if (a[t] < i) {
            b[t] = i;
        } else {
            for (int h = j + 1; h < b.length; h++) {
                b[h] = a[h - 1];
            }
        }

        for (int x = 0; x < b.length; x++) {
            System.out.println(b[x]);
        }
        
    }
}