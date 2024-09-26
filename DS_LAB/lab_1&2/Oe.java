//A 2. Write a program to find whether a number is odd or even

import java.util.Scanner;

public class Oe {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
       int b = a.nextInt();
       if(b%2==0){
        System.out.println("even");
       }
       else{
        System.out.println("odd");
       }
       a.close();
    }
    
}
