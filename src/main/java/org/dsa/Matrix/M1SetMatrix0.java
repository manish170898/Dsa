package org.dsa.Matrix;

public class M1SetMatrix0 {

//    Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//
//    You must do it in place.
//
//
//
//            Example 1:
//
//
//    Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//    Output: [[1,0,1],[0,0,0],[1,0,1]]
//    Example 2:
//
//
//    Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//    Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
//
//    Constraints:
//
//    m == matrix.length
//    n == matrix[0].length
//1 <= m, n <= 200
//            -231 <= matrix[i][j] <= 231 - 1


    public static void main(String[] args){
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

        int columns = matrix[0].length;
        int rows = matrix.length;

        boolean firstRow = false;
        boolean firstColumn = false;

        for(int i=0; i<rows; i++){
            if(matrix[i][0] == 0){
                firstRow = true;
            }
        }

        for(int i=0; i<columns; i++){
            if(matrix[0][i] == 0){
                firstColumn = true;
            }
        }

        for(int i=1; i<rows; i++){
            for(int j=1; j<columns; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i<rows; i++){
            if(matrix[i][0] == 0){
                for(int j=0; j<columns; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=1; i<columns; i++){
            if(matrix[0][i] == 0){
                for(int j=0; j<rows; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        if(firstRow){
            for(int i=0; i<rows; i++){
                matrix[i][0] = 0;
            }
        }
        if (firstColumn){
            for(int i=0; i<columns; i++){
                matrix[0][i] = 0;
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
}
