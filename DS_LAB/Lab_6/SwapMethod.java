//33. Write a program to swap two numbers using user-defines method.
public class SwapMethod{
    public static void main(String[] args) {
        
        Swapit(1, 2);

    }
    public static void Swapit(int a,int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a+","+b);
        
        
    }
}

   
