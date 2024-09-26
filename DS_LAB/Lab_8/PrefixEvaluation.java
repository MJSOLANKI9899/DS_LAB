import java.util.Stack;
import java.util.Scanner;

public class PrefixEvaluation {
    public static int evaluatePrefix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            }
            else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                
                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the prefix expression:");
        String prefixExpression = sc.nextLine();
        sc.close();

        int result = evaluatePrefix(prefixExpression);
        System.out.println("The result of the prefix expression is: " + result);
    }
}