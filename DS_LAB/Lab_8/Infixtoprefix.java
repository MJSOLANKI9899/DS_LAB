import java.util.Scanner;

class Stack {

    char[] S;
    int top = 0;
    String infix;
    String reverse_infix = "";
    String postfix = "";
    String prefix="";

    public Stack(String infix) {
        this.infix = infix;
        this.S = new char[infix.length()];
        S[top] = '(';
    }
    public void reverse_infix(){
        for(int i = infix.length()-1 ; i >= 0; i--){
            if(infix.charAt(i)=='('){
                reverse_infix+=')';
            }
            else if(infix.charAt(i) == ')'){
                reverse_infix+='(';
            }
            else{
                reverse_infix+=infix.charAt(i);
            }
        }
    }
    public void stackPrecedences() {

        for (int i = 0; i < reverse_infix.length(); i++) {
            if (reverse_infix.charAt(i) == '+') {
                int value = stack_precedence_value('+');
                stack_push(value, reverse_infix.charAt(i));
            } 
            else if (reverse_infix.charAt(i) == '-') {
                int value = stack_precedence_value('-');
                stack_push(value, reverse_infix.charAt(i));

            } 
            else if (reverse_infix.charAt(i) == '*') {
                int value = stack_precedence_value('*');
                stack_push(value, reverse_infix.charAt(i));

            } 
            else if (reverse_infix.charAt(i) == '/') {
                int value = stack_precedence_value('/');
                stack_push(value,reverse_infix.charAt(i));

            } 
            else if (reverse_infix.charAt(i) == '^'){
                int value = stack_precedence_value('^');
                stack_push(value, reverse_infix.charAt(i));
            } 
            else if (reverse_infix.charAt(i) == '(') {
                int value = stack_precedence_value('(');
                stack_push(value, reverse_infix.charAt(i));
            } 
            else if (reverse_infix.charAt(i) == ')') {
                int value = stack_precedence_value(')');
                stack_push(value, reverse_infix.charAt(i));
            } 
            else if (reverse_infix.charAt(i) >= 97 && reverse_infix.charAt(i) <= 122 || reverse_infix.charAt(i) >= 65 && reverse_infix.charAt(i) <= 90 || reverse_infix.charAt(i) >= 48 && reverse_infix.charAt(i) <= 57 ) {
                postfix += reverse_infix.charAt(i);
            }
            else{
                System.out.println("Enter Valid Infix String in the input");
                System.exit(0);
            }
        }
    }

    public int stack_precedence_value(char data) {
        if (data == '+' || data == '-') {
            return 2;
        } 
        else if (data == '*' || data == '/') {
            return 4;
        } 
        else if (data == '^') {
            return 5;
        } 
        else if (data == '(') {
            return 1;
        }
        return 0;
    }

    public void stack_push(int values, char data) {

        int top_value = stack_precedence_value(S[top]);
        if (data == '(') {
            top++;
            S[top] = data;
        }
        else if (data == ')') {
            while (S[top] != '(') {
                postfix += S[top];
                top--;
            }
            top--;
        }
        else if (top_value < values) {
            top++;
            S[top] = data;
        } 
        else if (data == '^') {
            if(S[top] == '^' && data=='^' ){
                postfix += S[top];
                S[top]=data;
            }
            else{
                top++;
                S[top]= data;
            }
        } 
         
        else if (top_value > values) {
            while (data != ')' && stack_precedence_value(S[top]) > stack_precedence_value(data)) {
                    postfix +=S[top];
                    top--;
            }
            top++;
            S[top] = data;
        }
    }

    public void postfix_reverse(){
        // System.out.println(postfix.length());
        for(int i = postfix.length()-1 ; i >= 0; i--){
            if(postfix.charAt(i)=='('){
                prefix+=')';
            }
            else if(postfix.charAt(i) == ')'){
                prefix+='(';
            }
            else{
                prefix+=postfix.charAt(i);
            }
        }
    }
    public void display() {
        System.out.println("------------------------------"); 
        System.out.println("Prefix Expression : "+prefix);

    }
}

public class Infixtoprefix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Infix Expression = ");
        String infix = sc.nextLine();

        Stack s1 = new Stack(infix);
        s1.reverse_infix();
        s1.stackPrecedences();
        s1.postfix_reverse();
        s1.display();

    }
}