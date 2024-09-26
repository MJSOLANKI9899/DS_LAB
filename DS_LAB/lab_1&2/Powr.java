//B 6. Write a program to find power of a number using loop.
import java.util.Scanner;

public class Powr {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int x= a.nextInt();
        int y = a.nextInt();
        int z = 1;
        for(int i=1;i<y;i++){
            z = z * x;
        }
        System.out.println(z);
        a.close();
    }
}
