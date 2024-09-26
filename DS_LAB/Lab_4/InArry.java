import java.util.Scanner;
public class InArry {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] a = {1,2,3,4,5};
        System.out.println("Enter location");
        int i = sc.nextInt();
        System.out.println("Enter the no.");
        int j = sc.nextInt();
        int[] b = new int[a.length+1];
        b[i]=j;
        for(int t = 0;t<b.length;t++){
            if(t<i){
                b[t]=a[t];
            }
            else if(t>i){
                b[t]=a[t+1];
            }
        }
        for(int x = 0 ; x<b.length;x++){
            System.out.println(b[x]);
        }
        sc.close();
    }
}