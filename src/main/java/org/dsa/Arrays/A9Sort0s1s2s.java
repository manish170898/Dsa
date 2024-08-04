package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A9Sort0s1s2s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        Integer arr[] = new Integer[T];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int hi= T-1;
        int lo=0, mid=0;
        while (mid<hi){
            if(arr[mid]==0){
                arr[lo] ^= arr[mid];
                arr[mid] ^= arr[lo];
                arr[lo] ^= arr[mid];
                lo++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                arr[mid] ^= arr[hi];
                arr[hi] ^= arr[mid];
                arr[mid] ^= arr[hi];
                hi--;
            }
        }
        for(int i=0; i<T; i++) {
            System.out.println(arr[i]);
        }
    }

    // CORRECT
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
