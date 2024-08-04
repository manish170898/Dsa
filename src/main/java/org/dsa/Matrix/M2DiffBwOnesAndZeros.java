package org.dsa.Matrix;

public class M2DiffBwOnesAndZeros {
    public int[][] onesMinusZeros(int[][] grid) {

        int[] rowZeroCount = new int[grid.length];
        int[] rowOneCount = new int[grid.length];

        int[] colZeroCount = new int[grid[0].length];
        int[] colOneCount = new int[grid[0].length];

        int zeroCount = 0;
        int oneCount = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    rowZeroCount[i]++;
                    colZeroCount[j]++;
                }
                if(grid[i][j] == 1){
                    rowOneCount[i]++;
                    colOneCount[j]++;
                }
            }
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                grid[i][j] = rowOneCount[i] + colOneCount[j] - rowZeroCount[i] - colZeroCount[j];
            }
        }

        return grid;
    }
}
