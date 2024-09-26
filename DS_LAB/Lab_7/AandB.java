import java.util.Scanner;

public class AandB {
    public static void main(String[] args) {
        demo a = new demo();
        a.check();
    }
    
}
class demo{
    void check(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String : ");
        String word = sc.nextLine();
        int top = word.length();
        int A = 0;
        int B = 0;
        char[] ch = new char[top];
        for(int i = 0; i< top;i++) {
            ch[i] = word.charAt(i);
        }
        top--;
        while(top>=0){
            if(ch[top]=='a'||ch[top]=='A'){
                A++;
            }
            else if(ch[top]=='b'||ch[top]=='B'){
                B++;
            }
            top--;
        }
        if(A==B){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}
