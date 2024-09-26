import java.util.Scanner;

class Node {
    int data;
    Node link;
    
    public Node(int data) {
        this.data = data;
        this.link = null;
    }
}


public class SinglyLinkedList {
    Node first;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        } else {
            Node current = first;
            while (current.link != null) {
                current = current.link;
            }
            current.link = newNode;
        }
    }

    public void printList() {
        Node current = first;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.link;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter data for node " + (i + 1) + ": ");
            int data = scanner.nextInt();
            list.addNode(data);
        }

        System.out.print("The linked list is: ");
        list.printList();

        scanner.close();
    }
}
