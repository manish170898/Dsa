package org.dsa.BinarySearch;

public class B29FindPeakElement2 {
//    https://leetcode.com/problems/find-a-peak-element-ii/
    public static void main(String[] args) {
        int[][] mat = {{1,4},{3,2}};
        findPeakGrid(mat);
    }
    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m-1;
        while(low <= high){
            int mid = (low+high)/2;
            int maxEleIndex = getMaxEleRow(mat, mid);
            int maxElement = mat[maxEleIndex][mid];
            int before = Integer.MIN_VALUE;
            int after = Integer.MIN_VALUE;
            if(mid-1 > 0) before = mat[maxEleIndex][mid-1];
            if(mid+1 < m) after = mat[maxEleIndex][mid+1];
            if(maxElement> before && maxElement > after){
                return new int[]{maxEleIndex, mid};
            }
            else if(maxElement <= before) high = mid -1;
            else low = mid+1;
        }
        return new int[2];
    }
    public static int getMaxEleRow(int[][] mat, int mid){
        int maxEleRow = 0;
        int maxEle = 0;
        for(int i = 0; i<mat.length; i++){
            if(mat[i][mid] > maxEle){
                maxEle = mat[i][mid];
                maxEleRow = i;
            }
        }
        return maxEleRow;
    }
}
