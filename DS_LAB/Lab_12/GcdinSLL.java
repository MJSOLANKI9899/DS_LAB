import java.util.Scanner;

public class GcdinSLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first element in Node : ");
        int finfo = sc.nextInt();
        Singlylinkedlist a = new Singlylinkedlist();
        a.Atfirst(finfo);
        int i = -1;

        while (i != 0) {

            System.out.println();
            System.out.println(
                    "Enter 1 for insert at top,\nEnter 2 for add gcd of data between them,\nEnter 3 for display all elements ,\nEnter any thing else for terminate the programe :");
            i = sc.nextInt();
            System.out.println();
            if (i == 1) {
                System.out.print("Enter a new node data :");
                finfo = sc.nextInt();
                a.Atfirst(finfo);
            } else if (i == 2) {
                a.add();
            } else if (i == 3) {
                a.Display();
            } else {
                System.out.println(
                        "---------------the program has been termineted successfully!------------------------------------------");
                break;
            }
            System.out.println("--------------------------------------------------------------");
            System.out.println();

        }
        sc.close();
    }
}

class Singlylinkedlist {
    static Node first = null;
    static int count = 0;

    void Atfirst(int info) {
        Node newnode = new Node(info);
        newnode.link = first;
        first = newnode;
        count++;
    }

    void add() {
        Node temp = first;
        Node save = first.link;
        while (save != null) {
            Node newnode = new Node(Gcd(temp.info, save.info));
            temp.link = newnode;
            newnode.link = save;
            temp = save;
            save = save.link;
        }
        System.out.println("GCD completed successfully! ");
    }

    int Gcd(int n1, int n2) {
        if (n2 > n1) {
            return Gcd(n2, n1);
        } else if (n2 != 0) {
            return Gcd(n2, n1 % n2);
        } else {
            return n1;
        }
    }

    void Display() {
        Node save = first;
        while (save != null) {
            System.out.print(save.info + ",");
            save = save.link;
        }
        System.out.println();
    }
}

class Node {
    int info;
    Node link;

    Node(int info) {
        this.info = info;
        this.link = null;
    }
}