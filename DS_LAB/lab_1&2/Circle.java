//A 1. Write a program to calculate area of a Circle (A = πr2).

import java.util.Scanner;
public class Circle{
    public static void main(String[] args){
        Scanner a = new Scanner(System.in);
        double r = a.nextDouble();
        double Ab = Math.PI*r*r;
        System.out.println(Ab);
        a.close();
    }
}