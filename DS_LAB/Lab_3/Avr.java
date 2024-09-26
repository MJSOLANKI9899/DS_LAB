import java.util.Scanner;
public class Avr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = (n*(n+1))/4;
        System.out.println(sum);
        sc.close();
    }
}
