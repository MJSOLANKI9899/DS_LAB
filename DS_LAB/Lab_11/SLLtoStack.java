import java.util.Scanner;

public class SLLtoStack{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first element in stack : ");
        int finfo = sc.nextInt();
        Singlylinkedlist a = new Singlylinkedlist();
        a.Atfirst(finfo);
        int i=-1;

        while(i!=0){
            System.out.println("Enter 1 for insert at top , Enter 2 for delete top element,Enter 3 for display all elements,Enter any thing else for terminate the programe :");
            i = sc.nextInt();
            if(i==1){
                System.out.print("Enter the element : ");
                int element = sc.nextInt();
                a.Atfirst(element);

                
            }
            else if(i==2){
                System.out.print("Enter the element : ");
                a.delete();
                
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
    void delete(){
        if(first == null){
            System.out.println("stack undeflow");
        }
        else{
            System.out.println("The deleted element is "+first.info);
            first = first.link;
        }
    }
    void Display(){
        Node save = first;
        while(save != null){
            System.out.println(save.info);
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