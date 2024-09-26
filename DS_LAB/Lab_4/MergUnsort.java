import java.util.Scanner;

public class MergUnsort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the first arry : ");
        int l1 = sc.nextInt();
        int[] a = new int[l1];
        for (int i = 0; i < l1; i++) {
            System.out.print("Enter the a[" + i + "] element : ");
            a[i] = sc.nextInt();
        }
        System.out.print("Enter the length of the second arry : ");
        int l2 = sc.nextInt();
        int[] b = new int[l2];
        for (int i = 0; i < l2; i++) {
            System.out.print("Enter the b[" + i + "] element : ");
            b[i] = sc.nextInt();
        }
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < l1; i++) {
            c[i] = a[i];
        }
        for (int i = a.length; i < l1 + l2; i++) {
            c[i] = b[i - l1];
        }
        for (int i = 0; i < l1 + l2; i++) {
            System.out.println(c[i]);
        }
        sc.close();
    }
}
