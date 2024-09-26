import java.util.Scanner;

public class SLLtoqueue{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first element in queue : ");
        int finfo = sc.nextInt();
        Singlylinkedlist a = new Singlylinkedlist();
        a.Atfirst(finfo);
        int i=-1;

        while(i!=0){
            
            System.out.println();
            System.out.println("Enter 1 for insert at top ,\nEnter 2 for delete last element,\nEnter 3 for display all elements,\nEnter any thing else for terminate the programe :");
            i = sc.nextInt();
            System.out.println();
            if(i==1){
                System.out.print("Enter the element : ");
                int element = sc.nextInt();
                a.Atfirst(element);

                
            }
            else if(i==2){
                System.out.print("Enter the element : ");
                a.deletelast();
                
            }
            else if(i==3){
                a.Display();
            }
            else{
                break;
            }

        }
    }
}
class Singlylinkedlist{
    static Node first = null;
    void Atfirst(int info){
        Node newnode = new Node(info);
            newnode.link=first;
            first = newnode;
    }
    void deletelast(){
        Node last = first;
        if(first == null){
            System.out.println("stack undeflow");
        }
        else{
            while(last.link.link != null){
                last = last.link;
            }
            last.link=null;
        }
    }
    void Display(){
        Node save = first;
        while(save != null){
            System.out.print(save.info+",");
            save = save.link;
        }
        
    }
}
class Node{
    int info;
    Node link;
    Node(int info){
        this.info = info;
        this.link = null;
    }
}