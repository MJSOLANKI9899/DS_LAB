//B 7. Write a program to find factors of a given number.
import java.util.Scanner;

public class Factor {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        for (int i = 1; i <= b; i++) {
            if (b % i == 0) {
                System.out.println(i);
            }
        }
        a.close();
    }

}
