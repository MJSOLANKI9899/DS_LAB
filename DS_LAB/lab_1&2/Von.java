//A 3. Write a program to determine whether the entered character is vowel or not.

import java.util.Scanner;

public class Von {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
       char b = a.next().charAt(0);
       if(b=='a'||b=='e'||b=='i'||b=='o'||b=='u'||b=='A'||b=='E'||b=='I'||b=='O'||b=='U'){
        System.out.println("vowel");
       }
       else{
        System.out.println("not vowel");
       }

       a.close();
    }
}
