package org.dsa.SlidingWindowTwoPointers;

public class Q17TrappingRainWater {
//    https://leetcode.com/problems/trapping-rain-water/description/
    public static void main(String[] args) {

    }

    // Better than Brute Force Solution
//    TC - O(N)   SC - O(N)
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] left = new int[n];
        int[] right = new int[n];
        int storedWater = 0;

        // Fill left array
        // moving from left to right to get left max till there
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        // Fill right array
//        move from right to left to get right maximum
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }


//        Take Min from both so thats the height for nthere and subtract from current heigth
        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(left[i], right[i]);
            storedWater += minHeight - height[i];
        }

        return storedWater;
    }

//    TC - O(N) , SC - O(1)
    // so here we have 2 pointer approach .. where we start l from left and r from right in opposite sirections ..
//    have leftMax and RightMax as the maximum heights till now ... and increment l or r based of which is smaller .... also we calculate the water sorted at that point by doing height of which ever is shorter - max of that side
    public int trapOptimal(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int storedWater = 0;
        int l = 0, r = n-1;
        int leftMax = 0, rightMax = 0;
        while(l<r){
            if(height[l] > leftMax){
                leftMax = height[l];
            }
            if(height[r] > rightMax){
                rightMax = height[r];
            }


            if(leftMax < rightMax){
                storedWater += leftMax - height[l];
                l++;
            }
            else {
                storedWater += rightMax - height[r];
                r--;
            }
        }

        return storedWater;
    }
}
