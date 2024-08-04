package org.dsa.Arrays;

public class arrayToReducedForm {

    /*

    Input:  arr[] = {10, 40, 20}
    Output: arr[] = {0, 2, 1}

    Method 2 (Efficient)
The idea is to use hashing and sorting. Below are the steps.
1) Create a temp array and copy the contents of the given array to temp[]. This takes O(n) time.
2) Sort temp[] in ascending order. This takes O(n Log n) time.
3) Create an empty hash table. This takes O(1) time.
4) Traverse temp[] from left to right and store mapping of numbers and their values (in converted array) in the hash table. This takes O(n) time on average.
5) Traverse given array and change elements to their positions using a hash table. This takes O(n) time on average.
     */
}
