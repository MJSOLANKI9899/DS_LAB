//C 9. WAP to convert seconds into hours, minutes & seconds and print in HH:MM:SS 
//[e.g. 10000 seconds mean 2:46:40 (2 Hours, 46 Minutes, 40 Seconds)]
import java.util.Scanner;

public class Hms {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int s = a.nextInt();

        int hh=s/24;
        s%=24;
        int mm=s/60;
        s%=60;
        int ss=s;
        System.out.println(hh+":"+mm+":"+ss);
        a.close();
    }
    
}
