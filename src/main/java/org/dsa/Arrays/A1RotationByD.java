package org.dsa.Arrays;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//Instead of moving one by one, divide the array into different sets where the number of sets is equal to the GCD of N and d (say X. So the elements which are
// X distance apart are part of a set) and rotate the elements within sets by 1 position to the left.
//
//        Calculate the GCD between the length and the distance to be moved.
//        The elements are only shifted within the sets.
//        We start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at the right place.
public class A1RotationByD {
//    https://www.geeksforgeeks.org/array-rotation/
    public static void main(String[] args){
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        leftRotate(arr, 10,arr.length);
        printArray(arr, arr.length);


    }
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    static void leftRotate(int[] arr, int d, int n)
    {
        /* To handle if d >= n */
        d = d % n;
        int i, j, k, temp;
        int g_c_d = gcd(d, n);
        for (i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }
    static void printArray(int[] arr, int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }


    public void rotate(int[] nums, int k) {
        if(nums.length != 1){
            striverRightRotate(nums, k%nums.length, nums.length);
        }

    }

    static void striverRightRotate(int[] arr, int d, int n){
        arr = reverse(arr,0,n-d-1);
        arr = reverse(arr, n-d, n-1);
        arr = reverse(arr,0,n-1);
    }

    static int[] reverse(int[] arr, int begin, int end){
        while(begin <= end){
            int temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin ++;
            end --;
        }
        return arr;
    }


}
