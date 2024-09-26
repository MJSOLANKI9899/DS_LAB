import java.util.Scanner;

public class Swap2SLL {
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
                    "Enter 1 for insert at top,\nEnter 2 for swap data list,\nEnter 3 for display all elements ,\nEnter any thing else for terminate the programe :");
            i = sc.nextInt();
            System.out.println();
            if (i == 1) {
                System.out.print("Enter a new node data :");
                finfo = sc.nextInt();
                a.Atfirst(finfo);
            } else if (i == 2) {
                a.swap2p();
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

    void swap2p() {
       Node temp = first;
       Node save = first.link;
       Node prev = null;
       if(first.link!=null){
        temp.link = save.link;
        save.link = temp;
        first = save;
        while(temp.link!=null&&temp.link.link!=null){
            prev = temp;
            temp = temp.link;
            save = temp.link;
            temp.link = save.link;
            save.link = temp;
            prev.link = temp;

        }
       }
      
       
    }

    void Display() {
        Node save = first;
        while (save != null) {
            System.out.print(save.info + ",");
            save = save.link;
        }
        System.out.println("count = " + count);

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