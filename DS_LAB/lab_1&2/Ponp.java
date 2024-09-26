//B 8. Write a program to check whether a number is prime or not
import java.util.Scanner;

public class Ponp {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        int b = a.nextInt();
        int i = 2;

        a.close();

        for (i = 2; i < Math.sqrt(b); i++) {
            if (b % i == 0) {
                System.out.println("not prime");
            }
        }

        if (b % i != 0) {
            System.out.println("prime");
        }

    }
}
