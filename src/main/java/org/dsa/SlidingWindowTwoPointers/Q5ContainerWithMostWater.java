package org.dsa.SlidingWindowTwoPointers;

public class Q5ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        maxArea(arr);
    }

//    https://leetcode.com/problems/container-with-most-water/
    public static int maxArea(int[] height) {
        int i=0; int j=height.length-1;
        int ans = 0;
        int area = 0;
        while(i <= j){
            area = Math.min(height[i],height[j]) * (j-i);
            ans = Math.max(ans, area);
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
}
