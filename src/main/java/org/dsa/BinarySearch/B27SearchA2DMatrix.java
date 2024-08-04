package org.dsa.BinarySearch;

public class B27SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        for(int i=0; i<matrix.length; i++){
            if(target > matrix[i][m-1]){
                continue;
            }
            else{
                int low = 0;
                int high = m-1;
                while(low <=high){
                    int mid = (low+high)/2;
                    if(matrix[i][mid] == target) return true;
                    else if(matrix[i][mid] > target) high = mid-1;
                    else low = mid+1;
                }
            }
        }
        return false;
    }
}
