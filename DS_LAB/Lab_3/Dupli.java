
import java.util.Scanner;

public class Dupli {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many number you want to add =");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter Number =");
            arr[i] = sc.nextInt();
        }
        int j = 0;
        int i;
        int count = 0;
        for (i = 0; i < arr.length - 1; i++) {
            for (j = i + 1; j < arr.length - 1; j++) {
                if (arr[i] == arr[j]) {
                    break;
                }

            }
            if (arr[i] == arr[j]) {
                count++;
                System.out.println("Array Contains Duplicate Number");
                break;
            }

        }
        if (count == 0) {
            System.out.println("Array Don't Contains any Duplicate Number");

        }

    }
}
