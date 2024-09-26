import java.util.Scanner;

class Node {
    int data;
    Node link;
    
    public Node(int data) {
        this.data = data;
        this.link = null;
    }
}


public class Demolist {
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

    public boolean isSameList(Demolist otherList) {
        Node current1 = this.first;
        Node current2 = otherList.first;

        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.link;
            current2 = current2.link;
        }

        return current1 == null && current2 == null;
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
        Demolist list1 = new Demolist();
        Demolist list2 = new Demolist();

        System.out.println("Enter elements for the first list (enter -1 to end):");
        while (true) {
            int data = scanner.nextInt();
            if (data == -1) {
                break;
            }
            list1.addNode(data);
        }

        System.out.println("Enter elements for the second list (enter -1 to end):");
        while (true) {
            int data = scanner.nextInt();
            if (data == -1) {
                break;
            }
            list2.addNode(data);
        }

        System.out.print("First list: ");
        list1.displayList();
        System.out.print("Second list: ");
        list2.displayList();

        boolean result = list1.isSameList(list2);
        if (result) {
            System.out.println("The lists are the same.");
        } else {
            System.out.println("The lists are different.");
        }

        scanner.close();
    }
}
