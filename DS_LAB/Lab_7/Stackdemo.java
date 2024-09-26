import java.util.Scanner;

public class Stackdemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of stack : ");
        int n = sc.nextInt();
        stack s1 = new stack(n, 0);
        int top = s1.push();
        s1.Display();
        top = s1.pop(top);
        System.out.print("Enter a no. to peep/seek");
        int i = sc.nextInt();
        s1.peep(top, i);
        System.out.print("enter the position : ");
        int position = sc.nextInt();
        System.out.print("enter the no. : ");
        int no = sc.nextInt();
        s1.change(top,position,no);
    }
}

class stack {
    int length;
    int top;
    int[] arry = new int[length];

    stack(int n, int top) {
        length = n;
        this.top = top;
    }

    int push() {
        if (top >= arry.length - 1) {
            System.out.println("Stack over flow");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the " + top + " value in stack : ");
            arry[top] = sc.nextInt();
            top++;
            push();
        }

        return top;
    }

    void Display() {
        for (int i = arry.length; i >= 0; i++) {
            System.out.println(arry[i]);
        }
    }

    int pop(int n) {
        if (n < 0) {
            System.out.println("stack underflow");
        } else {
            n--;
            System.out.println(arry[n]);
        }
        return top;
    }

    void peep(int n, int i) {

        if (n - i + 1 < 0) {
            System.out.println("Ther is no any element in position " + i);
        } else {
            System.out.println(arry[n - i + 1]);
        }

         
    }
    void  change(int n,int i,int no){
        if(n - i + 1 < 0){
            System.out.println("Ther is no any element in position " + i);
        }
        else if(n - i + 1>n){
            System.out.println("ther is no such position ");
        }
        else{
            arry[n-i+1]=no;
            System.out.println("element changed successfullys");
        }
    }
}