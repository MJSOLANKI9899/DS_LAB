import java.util.Scanner;

public class SortSLL {
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
                    "Enter 1 for insert at top,\nEnter 2 for sort whole list,\nEnter 3 for display all elements ,\nEnter any thing else for terminate the programe :");
            i = sc.nextInt();
            System.out.println();
            if (i == 1) {
                System.out.print("Enter a new node data :");
                finfo = sc.nextInt();
                a.Atfirst(finfo);
            } else if (i == 2) {
                a.SortList();
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
    static int count;

    void Atfirst(int info) {
        Node newnode = new Node(info);
        newnode.link = first;
        first = newnode;
    }

    void SortList() {
        Node temp = first;
        int min = temp.info;
        Node save = first.link;
        while (true) {
            if (save == null) {
                temp = temp.link;
                save = temp.link;
                min = temp.info;
            } else if (min > save.info) {
                min = save.info;
                save.info = temp.info;
                temp.info = min;
            } 
            if (temp.link.link == null) {
                break;
            } else {
                save = save.link;
            }
        }
        System.out.println("The list has been sorted! ");

    }

    void Display() {
        Node save = first;
        count = 0;
        while (save != null) {
            System.out.print(save.info + ",");
            save = save.link;
            ++count;
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