// 31. Read two matrices, first 3x2 and second 2x3, perform multiplication operation 
// and store result in third matrix and print it.

import java.util.Scanner;

public class MatrixMulti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[3][2];
        int[][] b = new int[2][3];
        int[][] c = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter a[" + (i + 1) + "][" + (j + 1) + "] element : ");
                a[i][j] = sc.nextInt();

            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter b[" + (i + 1) + "][" + (j + 1) + "] element : ");
                b[i][j] = sc.nextInt();

            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2) {
                    System.out.println(c[i][j]);
                } 
                else {
                    System.out.print(c[i][j]+",");
                }
            }
        }
        sc.close();
    }
}
