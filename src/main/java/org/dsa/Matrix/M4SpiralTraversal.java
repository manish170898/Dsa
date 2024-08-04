package org.dsa.Matrix;

import java.util.ArrayList;
import java.util.List;

public class M4SpiralTraversal {
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        spiralOrder(matrix);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> ans = new ArrayList<>();
        int k=0;

        int top = 0, bottom = n-1;
        int left = 0, right = m-1;

        // int dir = 'R';   // 'L', 'D', 'U'
        while(top <= bottom && left <= right){
            //Right Row Traversal
            int j=left;
            while(j<=right){
                ans.add(matrix[top][j]);
                j++;
            }
            top++;

            //Down Column Traversal
            int i=top;
            while(i<=bottom){
                ans.add(matrix[i][right]);
                i++;
            }
            right--;

            //Left Row Traversal
            if(top<=bottom){
                j=right;
                while(j>=left){
                    ans.add(matrix[bottom][j]);
                    j--;
                }
                bottom--;
            }

            if(left<=right){
                //Up Column Traversal
                i=bottom;

                while(i>=top){
                    ans.add(matrix[i][left]);
                    i--;
                }
                left++;
            }
        }
        return ans;
    }
}
