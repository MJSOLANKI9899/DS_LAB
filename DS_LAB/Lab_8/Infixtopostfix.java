import java.util.Scanner;

class Stack {

    char[] S;
    int top = 0;
    String infix;
    String postfix = "";

    public Stack(String infix) {
        this.infix = infix;
        this.S = new char[infix.length()];
        S[top] = '(';
    }

    public void stackPrecedences() {

        for (int i = 0; i < infix.length(); i++) {
            if (infix.charAt(i) == '+') {
                int value = stack_precedence_value('+');
                stack_push(value, infix.charAt(i));
            } else if (infix.charAt(i) == '-') {
                int value = stack_precedence_value('-');
                stack_push(value, infix.charAt(i));

            } else if (infix.charAt(i) == '*') {
                int value = stack_precedence_value('*');
                stack_push(value, infix.charAt(i));

            } else if (infix.charAt(i) == '/') {
                int value = stack_precedence_value('/');
                stack_push(value, infix.charAt(i));

            } else if (infix.charAt(i) == '^') {
                int value = stack_precedence_value('^');
                stack_push(value, infix.charAt(i));
            } else if (infix.charAt(i) == '(') {
                int value = stack_precedence_value('(');
                stack_push(value, infix.charAt(i));
            } else if (infix.charAt(i) == ')') {
                int value = stack_precedence_value(')');
                stack_push(value, infix.charAt(i));
            } else if (infix.charAt(i) >= 97 && infix.charAt(i) <= 122 || infix.charAt(i) >= 65 && infix.charAt(i) <= 90
                    || infix.charAt(i) >= 48 && infix.charAt(i) <= 57) {
                postfix = postfix + infix.charAt(i);
            } else {
                System.out.println("Enter Valid Infix String in the input");
                System.exit(0);
            }
        }
    }

    public int stack_precedence_value(char data) {
        if (data == '+' || data == '-') {
            return 2;
        } else if (data == '*' || data == '/') {
            return 4;
        } else if (data == '^') {
            return 5;
        } else if (data == '(') {
            return 1;
        }
        return 0;
    }

    public void stack_push(int values, char data) {

        int top_value = stack_precedence_value(S[top]);
        if (data == '(') {
            top++;
            S[top] = data;
        } else if (data == ')') {
            while (S[top] != '(') {
                postfix += S[top];
                top--;
            }
            top--;
        } else if (top_value < values) {
            top++;
            S[top] = data;
        } else if (data == '^') {
            top++;
            S[top] = data;
        } else if (top_value >= values) {

            while (data != ')' && stack_precedence_value(S[top]) >= stack_precedence_value(data)) {
                postfix += S[top];
                top--;
            }
            top++;
            S[top] = data;

        }
    }

    public void display() {
        System.out.println("------------------------------");
        System.out.println("Postfix Expression : " + postfix);
    }

}

public class Infixtopostfix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Infix Expression = ");
        String infix = sc.nextLine();

        Stack s1 = new Stack(infix);
        s1.stackPrecedences();
        s1.display();

    }
}