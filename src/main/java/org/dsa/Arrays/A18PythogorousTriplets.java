package org.dsa.Arrays;

import java.io.IOException;
import java.util.Arrays;

//Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
//
//        Example:
//
//        Input: arr[] = {3, 1, 4, 6, 5}
//        Output: True
//        There is a Pythagorean triplet (3, 4, 5).
//
//        Input: arr[] = {10, 4, 6, 12, 5}
//        Output: False
//        There is no Pythagorean triplet.
public class A18PythogorousTriplets {
    public static void main(String[] args) throws IOException {
        int arr[] = { 3, 1, 4, 6, 5 };
        int arr_size = arr.length;
        if (triplets(arr, arr_size) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static boolean triplets(int arr[], int n){
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] * arr[i];

        // Sort array elements
        Arrays.sort(arr);

        // Now fix one element one by one and find the other two
        // elements
        for (int i = n - 1; i >= 2; i--) {
            // To find the other two elements, start two index
            // variables from two corners of the array and move
            // them toward each other
            int l = 0; // index of the first element in arr[0..i-1]
            int r = i - 1; // index of the last element in arr[0..i-1]
            while (l < r) {
                // A triplet found
                if (arr[l] + arr[r] == arr[i])
                    return true;

                // Else either move 'l' or 'r'
                if (arr[l] + arr[r] < arr[i])
                    l++;
                else
                    r--;
            }
        }

        // If we reach here, then no triplet found
        return false;
    }

//BRUTE FORCE O(n3)
    static boolean isTriplet(int ar[], int n)
    {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Calculate square of array elements
                    int x = ar[i] * ar[i], y = ar[j] * ar[j], z = ar[k] * ar[k];

                    if (x == y + z || y == x + z || z == x + y)
                        return true;
                }
            }
        }

        // If we reach here, no triplet found
        return false;
    }
}
