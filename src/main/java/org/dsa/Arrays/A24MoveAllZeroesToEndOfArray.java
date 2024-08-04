package org.dsa.Arrays;

public class A24MoveAllZeroesToEndOfArray {
    public static void main(String[] args) {

    }
    public int[] moveZeroes(int[] arr, int N){
        int j=-1;
        for(int i=0; i<N; i++){
            if(arr[i] == 0 && j == -1){
                j=i;
            }
            if(arr[i] != 0 && j != -1){
                arr[j] = arr[i];
                arr[i] = 0;
                j++;
            }
        }
        return arr;
    }

}
