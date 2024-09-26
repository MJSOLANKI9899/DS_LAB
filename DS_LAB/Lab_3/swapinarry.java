import java.util.Scanner;

public class swapinarry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = { 1, 3, 4, 2, 5, 6 };
        System.out.print("Enter the first no. : ");
        int num1 = sc.nextInt();
        System.out.print("Enter the second no. : ");
        int num2 = sc.nextInt();
        int i = 0;
        int j = 0;
        int temp = 0;
        for (; i < a.length - 1; i++) {
            for (j = i + 1; j < a.length; j++) {
                if ((a[i] == num1 || a[i] == num2) && (a[j] == num1 || a[j] == num2)) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    temp = 1;
                    break;
                }
            }
            if (temp == 1) {
                break;
            }
        }
        System.out.print("position" + i + " no." + a[i]);
        System.out.print("position" + j + " no." + a[j]);
        for (i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        sc.close();
    }

}
