import java.util.Scanner;

public class demoqueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of Queue: ");
        int finfo = sc.nextInt();
        Queue a = new Queue(finfo);
        int i = -1;

        while (i != 0) {
            System.out.println();
            System.out.println(
                    "Enter 1 for insert at Rear," +
                            "\nEnter 2 for delete at front," +
                            "\nEnter 3 for display all elements," +
                            "\nEnter any other key to terminate the program:");
            i = sc.nextInt();
            System.out.println();
            if (i == 1) {
                a.enqueue(sc);
            } else if (i == 2) {
                a.dequeue();
                System.out.println();
            } else if (i == 3) {
                a.display();
                System.out.println();
            } else {
                System.out.println(
                        "---------------The program has been terminated successfully!------------------------------------------");
                break;
            }
            System.out.println("--------------------------------------------------------------");
        }
        sc.close();
    }
}

class Queue {
    int f;
    int r;
    int n;
    int Q[];

    Queue(int length) {
        Q = new int[length];
        this.f = -1;
        this.r = -1;
        this.n = length;
    }

    void enqueue(Scanner sc) {
        if (r >= n - 1) {
            System.out.println("Queue overflow!");
            return;
        }
        System.out.print("Enter the data: ");
        int data = sc.nextInt();
        if (f == -1) {
            f = 0;
            r = 0;
            Q[r] = data;
        } else {
            r++;
            Q[r] = data;
        }
    }

    void dequeue() {
        if (f == -1) {
            System.out.println("Queue underflow!");
            return;
        } else if (f == r) {
            System.out.println("The deleted element is " + Q[f]);
            f = -1;
            r = -1;
        } else {
            System.out.println("The deleted element is " + Q[f]);
            f++;
        }
    }

    void display() {
        if (f == -1) {
            System.out.println("Queue is empty!");
            return;
        }
        int temp = f;
        System.out.print("Queue: ");
        while (temp <= r) {
            System.out.print(Q[temp] + " ");
            temp++;
        }
        System.out.println();
    }
}
