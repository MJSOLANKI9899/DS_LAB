package Lab_18;

import java.util.Scanner;

public class Binary_search {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a no. to search from 1 to 5 in array : ");
        int i = sc.nextInt();
        int l = 0;
        int r = a.length - 1;
        if (a[l] == i) {
            System.out.println(l + "th position ");
        } else if (a[r] == i) {
            System.out.println(r + "th position");
        } else {
            while (l < r) {
                int m = (l+r)/2;
                if(a[m]==i){
                    System.out.println(m+"th position");
                    break;
                }
                else if(a[m]<i){
                    l = m+1;
                }
                else if(a[m]>i){
                    r = m-1;
                }
            }
            if (l == r) {
                System.out.println("not found!");
            }
        }
        

    }
}
