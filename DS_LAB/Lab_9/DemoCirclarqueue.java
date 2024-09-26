import java.util.Scanner;

public class DemoCirclarqueue {
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
                            "\nEnter 2 for insert at front," +
                            "\nEnter 3 for delete at front," +
                            "\nEnter 4 for delete at Rear," +
                            "\nEnter 5 for display all elements," +
                            "\nEnter any other key to terminate the program:");
            i = sc.nextInt();
            System.out.println();
            if (i == 1) {
                a.enqueueAtRear(sc);
            } else if (i == 2) {
                a.enqueueAtFront(sc);
                System.out.println();
            } else if (i == 3) {
                a.dequeueAtFront();
                System.out.println();
            } else if (i == 4) {
                a.dequeueAtRear();
                System.out.println();
            } else if (i == 5) {
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

    void enqueueAtRear(Scanner sc) {
        if ((r + 1) % n == f) {
            System.out.println("Queue overflow!");
        } else {
            System.out.print("Enter the data: ");
            int data = sc.nextInt();
            if (f == -1) {
                f = 0;
            }
            r = (r + 1) % n;
            Q[r] = data;
        }
    }

    void enqueueAtFront(Scanner sc) {
        if ((r + 1) % n == f) {
            System.out.println("Queue overflow!");
        } else {
            System.out.print("Enter the data: ");
            int data = sc.nextInt();
            if (f == -1) {
                f = 0;
                r = 0;
            } else {
                f = (f - 1 + n) % n;
            }
            Q[f] = data;
        }
    }

    void dequeueAtRear() {
        if (f == -1) {
            System.out.println("Queue underflow!");
        } else {
            System.out.println("The deleted element is " + Q[r]);
            if (f == r) {
                f = -1;
                r = -1;
            } else {
                r = (r - 1 + n) % n;
            }
        }
    }

    void dequeueAtFront() {
        if (f == -1) {
            System.out.println("Queue underflow!");
        } else {
            System.out.println("The deleted element is " + Q[f]);
            if (f == r) {
                f = -1;
                r = -1;
            } else {
                f = (f + 1) % n;
            }
        }
    }

    void display() {
        if (f == -1) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        int i = f;
        while (true) {
            System.out.print(Q[i] + " ");
            if (i == r) {
                break;
            }
            i = (i + 1) % n;
        }
        System.out.println();
    }
}
