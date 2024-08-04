package org.dsa.Graph;

public class G53PathWithMaximumGold {

    public static void main(String[] args) {
        int[][] grid = {{1,0,7,0,0,0},{2,0,6,0,1,0},{3,5,6,7,4,2},{4,3,1,0,2,0},{3,0,5,0,20,0}};
        getMaximumGold(grid);
    }

    static int[] row = {-1, 0, 1, 0};
    static int[] col = {0, 1, 0, -1};
    static int sum = 0;
    static int ans = 0;
    public static int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] != 0){
                    dfs(i, j, grid, vis);
                }
            }
        }
        return ans;
    }

    public static void dfs(int i, int j, int[][] grid, int[][] vis){
        vis[i][j] = 1;
        sum += grid[i][j];
        for(int k=0; k<4; k++){
            int nRow = i+row[k];
            int nCol = j+col[k];
            if(nRow>=0 && nCol>=0 && nRow<grid.length && nCol<grid[0].length && grid[nRow][nCol] != 0 && vis[nRow][nCol] != 1){
                dfs(nRow, nCol, grid, vis);
            }
        }
        ans = Math.max(ans, sum);
        vis[i][j] = 0;
        sum -= grid[i][j];
    }
}
