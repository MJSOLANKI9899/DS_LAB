import java.util.Scanner;

public class DemoCLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first element in Node : ");
        int finfo = sc.nextInt();
        Circularlinkedlist a = new Circularlinkedlist();
        a.Atfirst(finfo);
        int i = -1;

        while (i != 0) {

            System.out.println();
            System.out.println(
                    "Enter 1 for insert at top," +
                            "\nEnter 2 for insert at last," +
                            "\nEnter 3 for display all elements," +
                            "\nEnter 4 for delete node from spacified position," +
                            "\nEnter any thing else for terminate the programe :");
            i = sc.nextInt();
            System.out.println();
            if (i == 1) {
                System.out.print("Enter a new node data at firsy :");
                finfo = sc.nextInt();
                a.Atfirst(finfo);
            } else if (i == 2) {
                System.out.print("Enter a new node data at last :");
                finfo = sc.nextInt();
                a.Atlast(finfo);
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
    static Node first = null;
    static Node last = null;
    int count = 0;

    void Atfirst(int info) {
        Node newnode = new Node(info);
        if (first == null) {
            last = newnode;
            first = newnode;
        }
        newnode.link = first;
        first = newnode;
        last.link = first;
        count++;
    }

    void Atlast(int info) {
        Node newnode = new Node(info);
        if (last == null) {
            last = newnode;
            first = newnode;
        }
        last.link = newnode;
        last = newnode;
        newnode.link = first;
        count++;
    }

    void Display() {
        Node save = first;
        System.out.println("the circular linked list is :");
        while (save != last) {
            System.out.println(save.info + ",");
            save = save.link;
        }
        System.out.println(save.info+".");
    }

    void Delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the position of node to delete : ");
        int x = sc.nextInt();
        if (count < x || x < 0) {
            System.out.print("invalid position!");
        } else {
            if (x == 2) {
                first.link = first.link.link;
            } else if (x == 1) {
                last.link = first.link;
                first = first.link;

            } else {
                Node save = first.link;
                Node temp = first;
                int delete = 2;
                while (delete != count) {
                    if (x == count && delete == x) {
                        temp.link = first;
                        last = temp;
                    } else if (delete == x) {
                        temp = save.link;
                        break;
                    } else {
                        delete++;
                        save = save.link;
                        temp = temp.link;
                    }
                }
            }
            count--;
        }
        sc.close();
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
