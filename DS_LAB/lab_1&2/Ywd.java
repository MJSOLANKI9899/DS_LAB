//C 10. WAP to convert number of days into year, week & days [e.g. 375 days mean 1 year, 1 
//week and 3 days].
import java.util.Scanner;

public class Ywd {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int d = a.nextInt();

        int yy=d/365;
        d%=365;
        int ww=d/48;
        d%=48;
        int dd=d;
        System.out.println(yy+":"+ww+":"+dd);
        a.close();
    }
    
}
