package org.companySpecific.google;


// Q1 https://leetcode.com/discuss/interview-experience/5499901/Google-L3-ChancesExperience

/* Round 1:
        Find max length subarray which has all the element equal to key.(Two pointer question)
        Example : Given array a = [1,2,2,1,3,4,5,2,3,2,2,2] and key 2 then max length of subarray containing only 2 is 3(last three element).

        Now we are given key as querries, we need to give max length of subarray for each query.
        Example : Given array a = [1,2,2,1,3,4,5,2,3,2,2,2] and keys [1,2,3] , we have return [1,3,1]

        Now we need to find max length of subarray if you are allowed at most k different element apart from key.
        Example : Given array a = [1,2,2,1,3,4,5,2,3,2,2,2] and key 2 and k = 2 that means we need to find a max subarray with at most 2 elements differing from key 2. Output = 6
 */

import java.util.*;
public class SlidingWindow {
    public static void main(String[] args) {
        int arr[] = {1,2,2,1,3,4,5,3,3,3,3,2,3,2,2,2};
        int key[] = {3, 2, 1, 7};
        int[] max = findMaxSubarr(arr, key);
        int maxWithThreshold = findMaxSubarr(arr, 3, 2);
        System.out.println(maxWithThreshold);
        for(int i=0; i<key.length; ++i) {
            System.out.print(max[i] + " ");
        }
    }

    static int findMaxSubarr(int[] arr, int key, int threshold) {
        int n = arr.length;
        int localMax=0;
        int globalMax=0;

        int l=0;
        int r = 0;
        int t = 0;

        // 1,2,2,1,3,4,5,3,3,3,3,2,3,2,2,2
        //         l
        //                       r
        // t=3
        // gmax = 7

        while(r<n) {
            if(arr[r] != key) {
                ++t;
            }
            if(t > threshold) {
                if(arr[l] != key) {
                    --t;
                }
                ++l;
            }
            else
                globalMax = Math.max(globalMax, (r-l+1));
            ++r;
        }
        return globalMax;
    }


    static int[] findMaxSubarr(int[] arr, int[] key) {
        int n = arr.length;
        int q = key.length;

        Map<Integer, Integer> freqMap = new HashMap<>();

        int localMax=0;

        int l = 0;
        int r = 0;
        while(r<n) {
            if(arr[r] == arr[l]){
                localMax += 1;
            }
            else {
                localMax = 1;
                l = r;
            }
            if(freqMap.getOrDefault(arr[r], 0) < localMax) {
                freqMap.put(arr[r], localMax);
            }
            ++r;
        }
        int[] maxLens = new int[q];
        for(int i=0; i<q; ++i) {
            maxLens[i] = freqMap.getOrDefault(key[i], 0);
        }
        return maxLens;
    }
}
