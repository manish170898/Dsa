package org.dsa.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//
//Given a list arr of N integers, print sums of all subsets in it.
//
//
//
//        Example 1:
//
//        Input:
//        N = 2
//        arr[] = {2, 3}
//        Output:
//        0 2 3 5
//        Explanation:
//        When no elements is taken then Sum = 0.
//        When only 2 is taken then Sum = 2.
//        When only 3 is taken then Sum = 3.
//        When element 2 and 3 are taken then
//        Sum = 2+3 = 5.
//        Example 2:
//
//        Input:
//        N = 3
//        arr = {5, 2, 1}
//        Output:
//        0 1 2 3 5 6 7 8
//        Your Task:
//        You don't need to read input or print anything. Your task is to complete the function subsetSums() which takes a list/vector and an integer N as an input parameter and return the list/vector of all the subset sums.
//
//        Expected Time Complexity: O(2N)
//        Expected Auxiliary Space: O(2N)
//
//        Constraints:
//        1 <= N <= 15
//        0 <= arr[i] <= 104

public class A3SubsetSum1 {
//    https://leetcode.com/problems/subsets/
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3,2,2,6,7));
        System.out.println(subsetSum(list));
    }
    public static List<Integer> subsetSum(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        recursionSum(0, 0, list, list.size()-1,result);
        return result;
    }

    public static void recursionSum(int index, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> ds){
        if(index == N){
            ds.add(sum);
            return;
        }
        sum += arr.get(index);
        recursionSum(index + 1, sum, arr, N, ds);
        sum -= arr.get(index);
        recursionSum(index + 1, sum, arr, N, ds);
    }
}
