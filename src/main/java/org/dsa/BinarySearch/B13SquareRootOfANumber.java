package org.dsa.BinarySearch;

public class B13SquareRootOfANumber {
//    https://www.geeksforgeeks.org/problems/square-root/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=square-root
    long floorSqrt(long x)
    {
        // Your code here
        long low = 1;
        long high = x;
        long mid = 0;
        long ans = 0;
        while(low<=high){
            mid = (low+high)/2;
            if(mid*mid == x) return mid;
            else if(mid*mid < x){
                low = mid +1;
                if(mid > ans) ans = mid;
            }
            else if(mid*mid > x){
                high = mid-1;
            }
        }
        return ans;
    }
}
