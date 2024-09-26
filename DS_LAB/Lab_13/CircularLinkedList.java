public class CircularLinkedList {
    Node head;
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head; 
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }
    public void printList(Node start) {
        if (start == null) return;
        Node temp = start;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != start);
        System.out.println();
    }
    public void split() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node slow = head;
        Node fast = head;
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = slow.next;
        slow.next = head;

        Node temp = secondHalf;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = secondHalf; 

    
        System.out.print("First half: ");
        printList(head);
        System.out.print("Second half: ");
        printList(secondHalf);
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.add(1);
        cll.add(2);
        cll.add(3);
        cll.add(4);
        cll.add(5);
        cll.add(6);

        System.out.println("Original Circular Linked List:");
        cll.printList(cll.head);

        System.out.println("Splitting the Circular Linked List:");
        cll.split();
    }
}
