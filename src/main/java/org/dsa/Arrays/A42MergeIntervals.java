package org.dsa.Arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class A42MergeIntervals {

//    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]
//    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

    public static void main(String[] args){
        // SOLUTION 1
        // Naive solution would be O(N^2) where in you would look at each interval and see
        // with what interval it can be merged and then merge it

        //SOLUTION 2
        //Sort according to interval
        //THen merge in O(n) time
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        merge(intervals);
        // Time: O(nlogn)
        // Space: O(n)
        
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval: intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
