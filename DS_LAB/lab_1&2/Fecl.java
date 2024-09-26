//A 4. Write a program to find factorial of a number. (Using Loop)

import java.util.Scanner;

public class Fecl {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        int p = b;
        for(int i=2;i<p;i++){
            b = b * i;
        }
        System.out.println(b);
        a.close();
    }
}
