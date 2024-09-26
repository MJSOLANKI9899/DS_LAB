import java.util.Scanner;

public class PriorityQueueArray {
    private int[] queue;
    private int size;
    private int capacity;

    public PriorityQueueArray(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.size = 0;
    }

    public void insert(int item) {
        if (size == capacity) {
            System.out.println("Queue is full!");
            return;
        }
        queue[size] = item;
        size++;
        heapifyUp(size - 1);
    }

    public void delete() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Deleted element: " + queue[0]);
        queue[0] = queue[size - 1];
        size--;
        heapifyDown(0);
    }

    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Priority Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (index > 0 && queue[index] > queue[parentIndex]) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;

        if (leftChild < size && queue[leftChild] > queue[largest]) {
            largest = leftChild;
        }
        if (rightChild < size && queue[rightChild] > queue[largest]) {
            largest = rightChild;
        }
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the capacity of the Priority Queue:");
        int capacity = scanner.nextInt();
        PriorityQueueArray priorityQueue = new PriorityQueueArray(capacity);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int element = scanner.nextInt();
                    priorityQueue.insert(element);
                    break;
                case 2:
                    priorityQueue.delete();
                    break;
                case 3:
                    priorityQueue.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
