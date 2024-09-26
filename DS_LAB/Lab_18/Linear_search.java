package Lab_18;

import java.util.Scanner;

public class Linear_search {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a no. to search from 1 to 5 in array : ");
        int count=0;
        int i = sc.nextInt();
        for(int j = 0;j<a.length;j++){
            if(a[j]==i){
                count++;
                System.out.println(j+"th position : ");
                break;
            }
        }
    }
}
