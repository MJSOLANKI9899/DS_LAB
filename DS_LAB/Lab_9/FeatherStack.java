import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FeatherStack {
    private Queue<String> queue;

    public FeatherStack() {
        this.queue = new LinkedList<>();
    }

    public void buy(String color) {
        queue.add(color);
    }

    public void fetch() {
        if (queue.isEmpty()) {
            System.out.println("No feathers to fetch!");
            return;
        }

        // Remove the feather from the bottom and print it
        String bottomFeather = queue.poll();
        System.out.println(bottomFeather);

        // Move the bottom feather to the top
        queue.add(bottomFeather);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading number of queries
        int numQueries = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        FeatherStack featherStack = new FeatherStack();

        // Reading the queries
        String[] queries = scanner.nextLine().split(", ");

        for (String query : queries) {
            if (query.startsWith("buy_")) {
                String color = query.substring(4); // Extract color name
                featherStack.buy(color);
            } else if (query.equals("fetch")) {
                featherStack.fetch();
            }
        }

        scanner.close();
    }
}
