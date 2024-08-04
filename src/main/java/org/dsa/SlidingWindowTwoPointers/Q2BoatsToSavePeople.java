package org.dsa.SlidingWindowTwoPointers;

import java.util.Arrays;

public class Q2BoatsToSavePeople {

//    https://leetcode.com/problems/boats-to-save-people/description/
    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        numRescueBoats(people, limit);
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int sLimit = limit;
        int l = 0, r = people.length - 1;
        int count = 0;
        while (l <= r) {
            for (int i = 0; i < 2; i++) {
                if (people[r] <= sLimit) {
                    sLimit -= people[r];
                    r--;
                } else if (people[l] <= sLimit) {
                    sLimit -= people[l];
                    l++;
                }
                if (l > r) return ++count;
            }
            count++;
            sLimit = limit;
        }
        return count;
    }

    public static int optimized(int[] people, int limit) {
        int[] buckets = new int[limit + 1];
        for (int weight : people) {
            buckets[weight]++;
        }


        int start = 0;
        int end = buckets.length - 1;
        int boats = 0;
        while (start <= end) {
            while (start <= end && buckets[start] <= 0) start++;
            while (start <= end && buckets[end] <= 0) end--;

            if (buckets[start] <= 0 && buckets[end] <= 0) break;

            boats++;
            if (start + end <= limit) {
                buckets[start]--;
            }
            buckets[end]--;
        }
        return boats;
    }
}
