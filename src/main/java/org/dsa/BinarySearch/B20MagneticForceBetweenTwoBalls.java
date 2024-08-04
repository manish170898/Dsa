package org.dsa.BinarySearch;

import java.util.Arrays;

public class B20MagneticForceBetweenTwoBalls {
//    https://leetcode.com/problems/magnetic-force-between-two-balls/description/
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int minPos = position[0];
        int maxPos = position[position.length-1];

        int high = maxPos-minPos;
        int low = 1;
        int ans = 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(calculatePossible(position, m, mid)){
                ans = mid;
                low = mid +1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }

    public boolean calculatePossible(int[] position, int m, int mid){
        int count = 1;
        int i=0;
        int j=1;
        while(count != m && j < position.length){
            if(position[j] - position[i] >=mid){
                count++;
                i = j;
                j = j+1;
            }
            else{
                j++;
            }
        }
        if(count == m) return true;
        else return false;
    }
}

