import java.io.*;
import java.util.*;

public class Result {

    // Method to calculate resource allocation
    public static List<Integer> getResources(int inc, int dec, List<Integer> performance) {
        int n = performance.size(); // Size of the performance list

        List<Integer> resourceAllocation = new ArrayList<>(n); // Initialize resource allocation list

        // Debugging: Print the performance list
        System.out.println("Performance List: " + performance);

        int[] ranks = calculateRanks(performance); // Calculate ranks for each server
        int[] stricterCount = counterStricterPerformance(performance); // Count of stricter performance servers

        // Debugging: Print ranks and stricterCount
        System.out.println("Ranks: " + Arrays.toString(ranks));
        System.out.println("Stricter Count: " + Arrays.toString(stricterCount));

        // Calculate resource allocation for each server
        for (int i = 0; i < n; i++) {
            int allocation = inc * (n + 1 - ranks[i]) - dec * stricterCount[i];
            resourceAllocation.add(allocation);

            // Debugging: Print the allocation for each server
            System.out.println("Server " + i + " allocation: " + allocation);
        }

        return resourceAllocation; // Return the final resource allocation list
    }

    // Method to calculate ranks based on performance
    private static int[] calculateRanks(List<Integer> performance) {
        int n = performance.size();
        int[] ranks = new int[n];

        // Get unique performance values in descending order
        TreeSet<Integer> uniquePerformances = new TreeSet<>(performance);
        int rank = 1;

        // Debugging: Print the unique performance values
        System.out.println("Unique Performances: " + uniquePerformances.descendingSet());

        // Assign ranks based on descending order of performance
        for (int uniquePerf : uniquePerformances.descendingSet()) {
            for (int i = 0; i < n; i++) {
                if (performance.get(i) == uniquePerf) {
                    ranks[i] = rank;
                }
            }
            rank++;
        }
        return ranks;
    }

    // Method to count stricter performances (servers with higher performance)
    private static int[] counterStricterPerformance(List<Integer> performance) {
        int n = performance.size();
        int[] stricterCount = new int[n];

        // Count how many servers have a stricter performance than the current server
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (performance.get(j) > performance.get(i)) {
                    stricterCount[i]++;
                }
            }
        }

        // Debugging: Print stricter count array
        System.out.println("Stricter Count (inner): " + Arrays.toString(stricterCount));

        return stricterCount;
    }

    public static void main(String[] args) {
        int inc = 500;
        int dec = 100;
        List<Integer> list= new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(5);
        System.out.println(getResources(inc,dec,list));

    }
}

