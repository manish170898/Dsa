package org.dsa.StackAndQueue;

import java.util.Stack;

public class S19MaximalRectiangle {
    public int maximalRectangle(char[][] matrix) {
        int[][] matrixInt = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                matrixInt[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }
        for(int i=0; i<matrixInt.length; i++){
            for(int j=0; j<matrixInt[0].length; j++){
                if(matrixInt[i][j] != 0 && i-1 >=0){
                    matrixInt[i][j] += matrixInt[i-1][j];
                }
            }
        }
        int result = 0;
        for(int i=0; i<matrixInt.length; i++){
            result = Math.max(result, largestRectangleAreaOptimized(matrixInt[i]));
        }
        return result;
    }

    public int largestRectangleAreaOptimized(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        if(n==1) return heights[0];

        int result = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                Integer index = st.pop();
                result = Math.max(result, (i - pse[index] -1) * heights[index]);
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        while(!st.isEmpty()){
            Integer index = st.pop();
            result = Math.max(result, (n - pse[index] -1) * heights[index]);
        }
        return result;
    }
}
