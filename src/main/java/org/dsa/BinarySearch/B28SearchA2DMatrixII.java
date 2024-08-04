package org.dsa.BinarySearch;

public class B28SearchA2DMatrixII {
//    https://leetcode.com/problems/search-a-2d-matrix-ii/
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m-1;
        while(row < n && col>=0){
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}
