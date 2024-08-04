package org.dsa.BinarySearch;

public class B1SpecialArrayWithXElementsGreaterThanOREqualX {
//    https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/?envType=daily-question&envId=2024-05-27
    public int specialArray(int[] nums) {
        int[] numCounts = new int[nums.length+1];
        for(int num: nums)
            if(num>nums.length)
                numCounts[nums.length]++;
            else
                numCounts[num]++;
        int bigNumsCount = 0;
        for(int specialGuess = nums.length; specialGuess>0; specialGuess--){
            bigNumsCount += numCounts[specialGuess];
            if(bigNumsCount > specialGuess)
                return -1;
            if(bigNumsCount == specialGuess)
                return specialGuess;
        }
        return -1;
    }
}
