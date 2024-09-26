import java.util.Scanner;

public class CtvViseversa {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1 for celsius and 2 for fahrenheit : ");
        int a = sc.nextInt();
        float b = sc.nextInt();
            
        if(a==1){
            CtF(b);
        }
        else  if(a==2){
            FtC(b);
        }
        else{
            System.out.println("wrong formet");
        }

    }
    static void CtF(float C){
        float F;
        F = (9/5)*C + 32;
    }
    static void FtC(float F){
        float C;
        C = (F - 32)*5/9; 
    }
}
