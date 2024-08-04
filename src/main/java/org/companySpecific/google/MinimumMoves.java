package org.companySpecific.google;
import java.util.*;

public class MinimumMoves {

    public static boolean canTransform(int start, int target, int[] arr) {
        // Base case: If start is already equal to target
        if (start == target) {
            return true;
        }

        // Use a queue to facilitate BFS
        Queue<Integer> queue = new LinkedList<>();
        // A set to keep track of visited states to avoid cycles
        Set<Integer> visited = new HashSet<>();

        // Initialize the queue with the start integer
        queue.offer(start);
        visited.add(start);

        // Perform BFS
        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Explore all transformations with each element in the array
            for (int num : arr) {
                // Calculate the three possible transformations
                int add = current + num;
                int subtract = current - num;
                int xor = current ^ num;

                // Check if any transformation reaches the target
                if (add == target || subtract == target || xor == target) {
                    return true;
                }

                // Add each new state to the queue if it hasn't been visited
                if (!visited.contains(add)) {
                    queue.offer(add);
                    visited.add(add);
                }

                if (!visited.contains(subtract)) {
                    queue.offer(subtract);
                    visited.add(subtract);
                }

                if (!visited.contains(xor)) {
                    queue.offer(xor);
                    visited.add(xor);
                }
            }
        }

        // If the queue is exhausted and we haven't reached the target, return false
        return false;
    }

    public static void main(String[] args) {
        int start = 2;
        int[] arr = {50112, 512};

        for(int i=1; i<Integer.MAX_VALUE; i++) {
            int target = i;
            boolean result = canTransform(start, target, arr);
            System.out.println("Can transform " + i + ": " + result); // Output: true or false based on the test case
        }
    }
}
