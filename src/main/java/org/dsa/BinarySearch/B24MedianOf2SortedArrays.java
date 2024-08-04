package org.dsa.BinarySearch;

public class B24MedianOf2SortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        findMedianSortedArrays(nums1, nums2);
    }
    // NORMAL SOLUTION
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1+len2;

        int index1ToFind = totalLen/2;
        int index2ToFind = totalLen/2-1;

        double val1 = 0;
        double val2 = 0;

        int k = 0;
        int j = 0;
        int i = 0;
        for(i=0; i<totalLen; i++){
            if(k < len1 && j < len2){
                if(nums1[k] < nums2[j]){
                    if(i == index1ToFind) val1 = nums1[k];
                    if(i == index2ToFind) val2 = nums1[k];
                    k++;
                }
                else{
                    if(i == index1ToFind) val1 = nums2[j];
                    if(i == index2ToFind) val2 = nums2[j];
                    j++;
                }
            }
            else{
                break;
            }
        }
        while(i < totalLen && k < len1){
            if(i == index1ToFind) val1 = nums1[k];
            if(i == index2ToFind) val2 = nums1[k];
            i++;
            k++;
        }
        while(i < totalLen && j < len2){
            if(i == index1ToFind) val1 = nums2[j];
            if(i == index2ToFind) val2 = nums2[j];
            i++;
            j++;
        }
        double ans;
        if(totalLen%2 == 0) ans = (val1 + val2)/2;
        else ans =  val1;
        return ans;
    }

//    OPTIMIZED SOLUTION
public static double findMedianSortedArraysOpt(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    if(len1 > len2) return findMedianSortedArrays(nums2, nums1);

    int n = len1 + len2;
    int high  = len1;
    int low = 0;
    int maxNumbersLeft = ((len1+len2+1)/2);

    while(low <= high){
        int mid1 = (low + high)/2;
        int mid2 =  maxNumbersLeft - mid1;
        int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
        int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
        if(mid1 < len1) r1 = nums1[mid1];
        if(mid2 < len2) r2 = nums2[mid2];
        if(mid1-1 >= 0 ) l1 = nums1[mid1-1];
        if(mid2-1 >= 0 ) l2 = nums2[mid2-1];
        if(l1 <= r2 && l2 <= r1){
            if(n%2 == 1) return Math.max(l1,l2);
            return ((double)(Math.max(l1,l2) + Math.min(r1,r2)))/2.0;
        }
        else if(l1 > r2){
            high = mid1-1;
        }
        else if(l2 > r1){
            low = mid1+1;
        }
    }
    return 0;
}

}
