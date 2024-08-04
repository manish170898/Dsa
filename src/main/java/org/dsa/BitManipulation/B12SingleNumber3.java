package org.dsa.BitManipulation;

import java.util.Arrays;

public class B12SingleNumber3 {
//    Every number appears twice just 2 numbers appears once find those 2 numbers
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mostOptimized(new int[]{1,2,1,3,2,5})));
    }
    public static int[] mostOptimized(int[] nums){
        long xor = 0;
        for (int i=0; i< nums.length; i++){
            xor = xor ^ nums[i];
        }
        // TO get number with first bit set
        xor = (xor & (xor-1)) ^ xor;
        long b1 = 0;
        long b2 = 0;
        // putting in buckets if first bit is set or not
        for(int i=0; i< nums.length; i++){
            if((nums[i] & xor) != 0){
                b1 = b1^ nums[i];
            }
            else{
                b2 = b2 ^ nums[i] ;
            }
        }
        return new int[]{(int)b1,(int)b2};
    }
}
