import java.util.Scanner;

public class BalancedParentheses {
    
    public static int isBalanced(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++top] = ch; 
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (top == -1) {
                    return 0;
                }
                char topChar = stack[top--]; 
                if (!isMatchingPair(topChar, ch)) {
                    return 0; 
                }
            }
        }
        
        return top == -1 ? 1 : 0; 
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter No of Test Cases: ");
        int T = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < T; i++) {
            String testCase = scanner.nextLine();
            System.out.println(isBalanced(testCase));
        }
        
        scanner.close();
    }
}
