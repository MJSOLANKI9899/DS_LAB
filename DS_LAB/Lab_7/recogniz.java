import java.util.Scanner;

public class recogniz {
    public static void main(String[] args) {

        stack s1 = new stack();
        s1.getWord();

    }

}

class stack {
    String[] word = new String[1];

    stack() {
        this.word = word;
    }

    void getWord() {

        System.out.print("Enter a word : ");
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        if (a.length() % 2 == 0) {
            System.out.println(" false");
        }
        else {
            char[] b = new char[a.length()];
            int first = 0;
            int last = a.length() - 1;
            boolean check = true;
            for (int i = 0; i < a.length(); i++) {
                b[i] = a.charAt(i);
            }
            while (check) {
                if (b[first] != b[last]) {
                    System.out.println(" false");
                    check = false;
                } else if (first <= a.length() / 2) {
                    first++;
                    last--;
                } else {
                    break;
                }

            }
            if (first == a.length() / 2 + 1) {
                System.out.println("true");
            }

        }

    }

}