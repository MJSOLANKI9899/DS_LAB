import java.util.Scanner;

public class DemoDbLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first element in Node : ");
        int finfo = sc.nextInt();
        Circularlinkedlist a = new Circularlinkedlist();
        a.Atfront(finfo);
        int i = -1;

        while (i != 0) {

            System.out.println();
            System.out.println(
                            "Enter 1 for insert at front," +
                            "\nEnter 2 for insert at end," +
                            "\nEnter 3 for display all elements," +
                            "\nEnter 4 for delete node from spacified position," +
                            "\nEnter any thing else for terminate the programe :");
            i = sc.nextInt();
            System.out.println();
            if (i == 1) {
                System.out.print("Enter a new node data at firsy :");
                finfo = sc.nextInt();
                a.Atfront(finfo);
            } else if (i == 2) {
                System.out.print("Enter a new node data at last :");
                finfo = sc.nextInt();
                a.Atend(finfo);
            } else if (i == 3) {
                a.Display();
            } else if (i == 4) {
                a.Delete();
            } else {
                System.out.println(
                        "---------------the program has been termineted successfully!------------------------------------------");
                break;
            }
            System.out.println("--------------------------------------------------------------");
        }
        sc.close();
    }
}

class Circularlinkedlist {
    static Node L = null;
    static Node R = null;
    int count = 0;

    void Atfront(int info) {
        Node newnode = new Node(info);
        if (L == null && R == null) {
            L = newnode;
            R = newnode;
        }
        L.llink = newnode;
        newnode.rlink = L;
        L = newnode;
        count++;
    }

    void Atend(int info) {
        Node newnode = new Node(info);
        if (L == null && R == null) {
            L = newnode;
            R = newnode;
        }
        R.rlink = newnode;
        newnode.llink = R;
        R = newnode;
        count++;
    }

    void Display() {
        Node save = L;
        while (save != R) {
            System.out.println(save.info + ",");
            save = save.rlink;
        }
        if (save != null) {
            System.out.print(save.info);
        }
    }

    void Delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the position : ");
        int x = sc.nextInt();
        if (x > count) {
            System.out.println(" invalid position! ");
        } else {
            int temp = 2;
            Node save = L;
            if (L == R) {
                R = null;
                L = null;
            } else if (x == 1) {
                L = L.rlink;
                L.llink = null;
            } else if (x == count) {
                R = R.llink;
                R.rlink = null;
            } else {
                while (true) {
                    if (temp == x) {
                        save.rlink = save.rlink.rlink;
                        save.rlink.llink = save;
                        break;
                    }
                    temp++;
                    save = save.rlink;
                }
            }
            count--;
        }
        sc.close();
    }

}

class Node {
    int info;
    Node llink;
    Node rlink;

    Node(int info) {
        this.info = info;
        this.llink = null;
        this.rlink = null;
    }
}
