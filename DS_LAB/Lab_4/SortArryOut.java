import java.util.Scanner;

public class SortArryOut {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = { 1, 4, 7, 10, 13 };
        System.out.println("Enter no.");
        int num = sc.nextInt();
        int[] b = new int[a.length - 1];
        
        for(int i = 0;i<a.length;i++){
            if(a[i]<num){
                b[i]=a[i];

            }
            else if(a[i]>num){
                b[i-1]=a[i];
            }
        }
        for(int aa = 0;aa<b.length;aa++){
            System.out.println(b[aa]);
        }
        sc.close();
    }
}