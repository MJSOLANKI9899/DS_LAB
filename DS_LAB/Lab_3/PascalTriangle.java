import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows for Pascal's triangle: ");
        int rows = sc.nextInt();

        int[][] a = new int[rows][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i-1][j-1] + a[i-1][j];
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows - (i + 1); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
