package org.dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//https://leetcode.com/problems/number-of-islands/
public class G4NumberOfIlandsLeetCode {
    public static void main(String[] args) {
    char[][] grind = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    System.out.println(numIslands(grind));
    }

    public static int numIslands(char[][] grid) {
        int count =0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        for (int i=0 ; i<n; i++){
            for (int j=0; j<m; j++){
                if(grid[i][j] =='1' && vis[i][j] != 1){
                    count++;
                    vis[i][j] = 1;
                    dfs(i, j, grid, vis);
                }
            }
        }

        return count;
    }

    private static void dfs(int i, int j, char[][] grid, int[][] vis) {
        int[] delRow = new int[]{-1,0,+1,0};
        int[] delCol = new int[]{0,+1,0,-1};
        Queue<PairG> queue = new LinkedList<>();
        queue.offer(new PairG(i,j));
        int n = grid.length;
        int m = grid[0].length;
        while (!queue.isEmpty()){
            PairG p = queue.poll();
            int row = p.first;
            int col = p.second;
            for(int k=0 ; k<4; k++){
                int nrow = row + delRow[k];
                int ncol = col + delCol[k];
                if(nrow>=0 && nrow <n && ncol>=0 && ncol<m && grid[nrow][ncol] == '1' && vis[nrow][ncol] != 1){
                    vis[nrow][ncol] = 1;
                    queue.add(new PairG(nrow, ncol));
                }
            }
        }
    }
}
