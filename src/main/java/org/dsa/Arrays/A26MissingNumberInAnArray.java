package org.dsa.Arrays;

public class A26MissingNumberInAnArray {
//    https://leetcode.com/problems/missing-number/

    public static void main(String[] args) {
        missingNUmber2(new int[]{3,0,1});
    }

//    TC - O(N) SC - O(1)
    public Integer missingNumber(int[] arr, int N){
        // As sum of N natural numbers in N(N+1)/2
        int sum=0;
        int actualSum = N*(N+1)/2;
        for (int i=0; i<arr.length; i++){
            sum = sum + arr[i];
        }
        return  actualSum - sum;
    }

    // BETTER WAY BCS FOR suppose 10^5 input .. upper code will need long to store sum .. larger space required
//XOR USED
    public static Integer missingNUmber2(int[] arr){
        int xor1 = 0;
        int xor2 = 0;
        for (int i=0; i<= arr.length-1; i++){
            xor1 = xor1 ^ i+1;
            xor2 = xor2 ^ arr[i];
        }
        return xor2 ^ xor1;
    }
}


