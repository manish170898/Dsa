package org.dsa.Arrays;

public class A41ElementsAreConsecutive {
//    https://www.geeksforgeeks.org/check-array-elements-consecutive-time-o1-space-handles-positive-negative-numbers/
//    Find the sum of the array.
//    If given array elements are consecutive that means they are in AP. So, find min element i.e. first term of AP then calculate ap_sum = n/2 * [2a +(n-1)*d] where d = 1. So, ap_sum = n/2 * [2a +(n-1)]
//    Compare both sums. Print Yes if equal, else No.
    static Boolean areConsecutives(int arr[],
                                   int n)
    {
        // Find minimum element in array
        int first_term = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
        {
            if(arr[j] < first_term)
                first_term = arr[j];
        }

        // Calculate AP sum
        int ap_sum = (n * (2 * first_term +
                (n - 1) * 1)) / 2;

        // Calculate given array sum
        int arr_sum = 0;
        for (int i = 0; i < n; i++)
            arr_sum += arr[i];

        // Compare both sums and return
        return ap_sum == arr_sum;
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 2, 1, 0, -3, -1, -2 };
        int n = arr.length;

        Boolean result = areConsecutives(arr, n);
        if(result == true)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
