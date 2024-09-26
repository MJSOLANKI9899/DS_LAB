//A 5. Write a program to find factorial of a number. (Using Recursion)

import java.util.Scanner;

public class Fecr {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int z = a.nextInt();
          Recurson b = new Recurson();
          int kk = b.recur(z);
          System.out.println(kk);
          a.close();
    }
    
}
class Recurson{
    int recur(int a){
        if(a==0){
            return 1;
        }
        else{
            return a*recur(a-1);
        }
    }
}
