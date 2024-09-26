// 30. Read two 2x2 matrices and perform addition of matrices into third matrix and 
// print it
import java.util.Scanner;

public class MatrixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[2][2];
        int[][] b = new int[2][2];
        int[][] c = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter a[" + i + "][" + j + "] element : ");
                a[i][j] = sc.nextInt();

                System.out.print("Enter b[" + i + "][" + j + "] element : ");
                b[i][j] = sc.nextInt();

            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][j] + b[i][j];

            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(c[i][j]);

            }
        }

        sc.close();

    }

}