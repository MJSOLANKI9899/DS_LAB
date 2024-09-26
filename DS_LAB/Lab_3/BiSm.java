import java.util.Scanner;
public class BiSm{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int j = sc.nextInt();
            
        int Sm =j;
        int Bi = j;
        for(int i=0;i<n-1;i++){
             j = sc.nextInt();
        
              if(Sm>j){
                Sm=j;
             }
             if(Bi<j){
                Bi=j;
             }
        
        }
        System.out.println(Sm+","+Bi);
        sc.close();
    }
}