import java.util.Scanner;

class Node {
    int data;
    Node link;
    
    public Node(int data) {
        this.data = data;
        this.link = null;
    }
}


public class demolinkedlist {
    Node first;

    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        newNode.link = first;
        first = newNode;
    }

    public void insertAtEnd(int data) {
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

    public void deleteFirstNode() {
        if (first != null) {
            first = first.link;
        } else {
            System.out.println("List is empty.");
        }
    }

    public void deleteLastNode() {
        if (first == null) {
            System.out.println("List is empty.");
        } else if (first.link == null) {
            first = null;
        } else {
            Node current = first;
            while (current.link.link != null) {
                current = current.link;
            }
            current.link = null;
        }
    }

    public void deleteNodeAtPosition(int position) {
        if (first == null) {
            System.out.println("List is empty.");
            return;
        }
        
        if (position == 0) {
            first = first.link;
            return;
        }
        
        Node current = first;
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.link;
        }
        
        if ( current.link == null || current == null ) {
            System.out.println("Position out of range.");
            return;
        }
        
        current.link = current.link.link;
    }

    public void displayList() {
        if (first == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = first;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.link;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        demolinkedlist list = new demolinkedlist();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Insert a node at the front of the linked list");
            System.out.println("2. Insert a node at the end of the linked list");
            System.out.println("3. Delete the first node of the linked list");
            System.out.println("4. Delete the last node of the linked list");
            System.out.println("5. Delete a node from specified position");
            System.out.println("6. Display all nodes");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    int dataFront = scanner.nextInt();
                    list.insertAtFront(dataFront);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    int dataEnd = scanner.nextInt();
                    list.insertAtEnd(dataEnd);
                    break;
                case 3:
                    list.deleteFirstNode();
                    break;
                case 4:
                    list.deleteLastNode();
                    break;
                case 5:
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    list.deleteNodeAtPosition(position);
                    break;
                case 6:
                    list.displayList();
                    break;
                case 7:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
