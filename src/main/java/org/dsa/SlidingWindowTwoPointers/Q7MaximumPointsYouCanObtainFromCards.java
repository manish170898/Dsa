package org.dsa.SlidingWindowTwoPointers;

public class Q7MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        int[] arr = {11,49,100,20,86,29,72};
        int k =4;
        maxScore(arr, k);
    }
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int start = n-k;
        int end = n-k;
        int windowSum = 0;
        int length = 0;
        int ans = 0;
        int moves = 0;
        while(true){
            if(end>n-1){
                end = end % (n);
            }
            windowSum += cardPoints[end];
            length ++;
            while(length > k){
                if(start>n-1){
                    start = start %(n);
                }
                windowSum -= cardPoints[start];
                start++;
                length--;
            }
            ans = Math.max(ans, windowSum);
            end++;
            if(length == k){
                moves++;
            }
            if(moves == k+1) break;
        }
        return ans;
    }
}
