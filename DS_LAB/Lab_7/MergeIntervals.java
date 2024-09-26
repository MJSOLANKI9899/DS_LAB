import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergeIntervals {

    // Function to merge overlapping intervals
    public static void mergeIntervals(Interval[] intervals) {
        // Sort intervals based on the starting time
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));

        // Use a stack to store merged intervals
        Stack<Interval> stack = new Stack<>();

        // Push the first interval to the stack
        stack.push(intervals[0]);

        // Iterate through the intervals
        for (int i = 1; i < intervals.length; i++) {
            Interval top = stack.peek();

            // If the current interval does not overlap with the top interval in the stack, push it to the stack
            if (top.end < intervals[i].start) {
                stack.push(intervals[i]);
            } 
            // If the current interval overlaps with the top interval in the stack, merge them
            else if (top.end < intervals[i].end) {
                top.end = intervals[i].end;
                stack.pop();
                stack.push(top);
            }
        }

        // Print the merged intervals
        System.out.print("Merged Intervals: ");
        while (!stack.isEmpty()) {
            Interval t = stack.pop();
            System.out.print("[" + t.start + "," + t.end + "] ");
        }
    }

    public static void main(String[] args) {
        Interval[] intervals1 = new Interval[4];
        intervals1[0] = new Interval(1, 3);
        intervals1[1] = new Interval(2, 4);
        intervals1[2] = new Interval(6, 8);
        intervals1[3] = new Interval(9, 10);

        System.out.println("Intervals: {{1,3},{2,4},{6,8},{9,10}}");
        mergeIntervals(intervals1);

        System.out.println();

        Interval[] intervals2 = new Interval[4];
        intervals2[0] = new Interval(6, 8);
        intervals2[1] = new Interval(1, 9);
        intervals2[2] = new Interval(2, 4);
        intervals2[3] = new Interval(4, 7);

        System.out.println("Intervals: {{6,8},{1,9},{2,4},{4,7}}");
        mergeIntervals(intervals2);
    }
}
