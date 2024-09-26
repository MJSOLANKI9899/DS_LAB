import java.util.Scanner;

class Node {
    int data;
    Node link;
    
    public Node(int data) {
        this.data = data;
        this.link = null;
    }
}


public class CircularSinglyLinkedList {
    Node first;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
            first.link = first; 
        } else {
            Node current = first;
            while (current.link != first) {
                current = current.link;
            }
            current.link = newNode;
            newNode.link = first; 
        }
    }

    public int countNodes() {
        if (first == null) {
            return 0;
        }
        
        Node current = first;
        int count = 1;
        
        while (current.link != first) {
            count++;
            current = current.link;
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add node");
            System.out.println("2. Count nodes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    int data = scanner.nextInt();
                    list.addNode(data);
                    break;
                case 2:
                    int count = list.countNodes();
                    System.out.println("Number of nodes: " + count);
                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
