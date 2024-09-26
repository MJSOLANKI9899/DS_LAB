//C 11. WAP to find the sum of 1 + (1+2) + (1+2+3) + (1+2+3+4)+ …+(1+2+3+4+….+n).

import java.util.Scanner;

public class SumOfGivenNo {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Enter a no. : ");
        int b = a.nextInt();
        a.close();
        int sum = 0;
        for (int i = 1; i < b + 1; i++) {

            for (int j = 1; j < i + 1; j++) {
                sum += j;
            }
           
        }
        System.out.println("The sum is " + sum);

    }
}