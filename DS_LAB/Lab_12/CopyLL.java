import java.util.Scanner;

public class CopyLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first element in Node : ");
        int finfo = sc.nextInt();
        Singlylinkedlist a = new Singlylinkedlist();
        a.Atfirst(finfo);
        int i = -1;

        while (i != 0) {

            System.out.println();
            System.out.println("Enter 1 for insert at top,\nEnter 2 for copy whole list,\nEnter 3 for display all elements ,\nEnter 4 for display copyed elements,\nEnter any thing else for terminate the programe :");
            i = sc.nextInt();
            System.out.println();
            if(i==1){
                System.out.print("Enter a new node data :");
                finfo = sc.nextInt();
                a.Atfirst(finfo);
            }
            else if(i==2){
                a.Copy_whole_list();
            }
            else if(i==3){
                a.Display();
            }
            else if(i==4){
                a.Display_copyed();
            }
            else{
                break;
            }

        }
        sc.close();
    }
}

class Singlylinkedlist {
    static Node first = null;
    static int count = 0;
    static Node firstofcopy = null;

    void Atfirst(int info){
        Node newnode = new Node(info);
            newnode.link=first;
            first = newnode;
    }
    void Display() {
        Node save = first;
        while (save != null) {
            System.out.print(save.info + ",");
            count++;
            save = save.link;
        }

    }
    void Display_copyed() {
        Node save = firstofcopy;
        while (save != null) {
            System.out.print(save.info + ",");
            save = save.link;
        }

    }
    void Copy_whole_list(){
        Node save = first;
        int temp = 1;
        while(count != 0){
            if(count == temp){
                Node newlist = new Node(save.info);
                newlist.link = firstofcopy;
                firstofcopy = newlist;
                save = first;
                count--;
                temp = 1;
            }
            else{
                save = save.link;
                temp++;
            }
        }
        System.out.println("Link copyed susscess fully!");
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