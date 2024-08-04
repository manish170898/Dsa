package org.dsa.SlidingWindowTwoPointers;

public class Q13GetEqualSubstringsWithinBudget {
//    https://leetcode.com/problems/get-equal-substrings-within-budget/?envType=daily-question&envId=2024-05-28
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int start = 0;
        int currentCost = 0;
        int maxLength = 0;

        for (int end = 0; end < n; ++end) {
            currentCost += Math.abs(s.charAt(end) - t.charAt(end));

            if (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(start) - t.charAt(start));
                ++start;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
