import java.util.Scanner;

public class DequeArray {
    private int[] deque;
    private int front, rear, size, capacity;

    public DequeArray(int capacity) {
        this.capacity = capacity;
        deque = new int[capacity];
        front = -1;
        rear = 0;
        size = 0;
    }

    public void insertFront(int item) {
        if (size == capacity) {
            System.out.println("Deque is full!");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = capacity - 1;
        } else {
            front--;
        }
        deque[front] = item;
        size++;
    }

    public void insertRear(int item) {
        if (size == capacity) {
            System.out.println("Deque is full!");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == capacity - 1) {
            rear = 0;
        } else {
            rear++;
        }
        deque[rear] = item;
        size++;
    }

    public void deleteFront() {
        if (size == 0) {
            System.out.println("Deque is empty!");
            return;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == capacity - 1) {
            front = 0;
        } else {
            front++;
        }
        size--;
    }

    public void deleteRear() {
        if (size == 0) {
            System.out.println("Deque is empty!");
            return;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = capacity - 1;
        } else {
            rear--;
        }
        size--;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Deque is empty!");
            return;
        }
        int i = front;
        System.out.print("Deque elements: ");
        for (int count = 0; count < size; count++) {
            System.out.print(deque[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the capacity of the Deque:");
        int capacity = scanner.nextInt();
        DequeArray deque = new DequeArray(capacity);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at front end");
            System.out.println("2. Insert at rear end");
            System.out.println("3. Delete from front end");
            System.out.println("4. Delete from rear end");
            System.out.println("5. Display all elements");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert at front: ");
                    int frontElement = scanner.nextInt();
                    deque.insertFront(frontElement);
                    break;
                case 2:
                    System.out.print("Enter the element to insert at rear: ");
                    int rearElement = scanner.nextInt();
                    deque.insertRear(rearElement);
                    break;
                case 3:
                    deque.deleteFront();
                    break;
                case 4:
                    deque.deleteRear();
                    break;
                case 5:
                    deque.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
