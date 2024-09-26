//C 12. WAP to print Armstrong number from 1 to 1000
public class ArmstrongNumber {
    public static void main(String[] args) {
       
        for (int i = 1; i <= 1000; i++) {
            int x = i;
            int sum = 0;
            int digits = String.valueOf(i).length();// only this is inspired throu ChatGPT
            while (x != 0) {
                int r = x % 10;
                sum += Math.pow(r, digits);
                x /= 10;
            }

            if (sum == i) {
                System.out.println(i);
            }
        }
    }
}
