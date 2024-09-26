import java.util.Scanner;

public class ReverseSLL {
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
                    "Enter 1 for insert at top,\nEnter 2 for reverse whole list,\nEnter 3 for display all elements ,\nEnter any thing else for terminate the programe :");
            i = sc.nextInt();
            System.out.println();
            if (i == 1) {
                System.out.print("Enter a new node data :");
                finfo = sc.nextInt();
                a.Atfirst(finfo);
            } else if (i == 2) {
                a.ReverseList();
            } else if (i == 3) {
                a.Display();
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

class Singlylinkedlist {
    static Node first = null;
    static int count;

    void Atfirst(int info) {
        Node newnode = new Node(info);
        newnode.link = first;
        first = newnode;
        ++count;
    }

    void ReverseList() {
        Node temp = first;
        Node prev = null;
        Node next = null;

        while(temp!=null){
                next = temp.link;
                temp.link = prev;
                prev = temp;
                temp = next;
        }
        if(first!=null){
            first=prev;
        }
        System.out.println("the list has been reversed susceesfully");
    }

    void Display() {
        Node save = first;
        count = 0;
        while (save != null) {
            System.out.print(save.info + ",");
            System.out.println();
            save = save.link;

        }
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