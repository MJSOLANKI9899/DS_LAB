import java.util.Scanner;

public class DemoDADBLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first element in Node: ");
        int finfo = sc.nextInt();
        DoublyLinkedList a = new DoublyLinkedList();
        a.Atfirst(finfo);
        int i = -1;

        while (i != 0) {
            System.out.println();
            System.out.println(
                    "Enter 1 for insert at top," +
                            "\nEnter 2 for insert at last," +
                            "\nEnter 3 for display all elements," +
                            "\nEnter 4 for delete alternate nodes," +
                            "\nEnter any thing else for terminate the program:");
            i = sc.nextInt();
            System.out.println();
            if (i == 1) {
                System.out.print("Enter a new node data at first: ");
                finfo = sc.nextInt();
                a.Atfirst(finfo);
            } else if (i == 2) {
                System.out.print("Enter a new node data at last: ");
                finfo = sc.nextInt();
                a.Atlast(finfo);
            } else if (i == 3) {
                a.Display();
            } else if (i == 4) {
                a.DeleteAlternate();
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

class DoublyLinkedList {
    Node L = null;
    Node R = null;

    void Atfirst(int info) {
        Node newNode = new Node(info);
        if (L == null) {
            L = R = newNode;
        } else {
            newNode.llink = L;
            L.rlink = newNode;
            L = newNode;
        }
    }

    void Atlast(int info) {
        Node newNode = new Node(info);
        if (R == null) {
            L = R = newNode;
        } else {
            newNode.rlink = R;
            R.llink = newNode;
            R = newNode;
        }
    }

    void Display() {
        Node temp = L;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.llink;
        }
        System.out.println();
    }

    void DeleteAlternate() {
        if (L == null)
            return;

        Node temp = L;
        boolean delete = true;

        while (temp != null && temp.llink != null) {
            Node toDelete = temp.llink;
            temp.llink = toDelete.llink;
            if (toDelete.llink != null) {
                toDelete.llink.rlink = temp;
            }
            temp = temp.llink;
            delete = !delete;
        }
    }
}

class Node {
    int info;
    Node rlink, llink;

    public Node(int info) {
        this.info = info;
        this.rlink = null;
        this.llink = null;
    }
}
