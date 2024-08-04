package org.dsa.Graph;

public class G5FloodFill {
//    https://leetcode.com/problems/flood-fill/
    public static void main(String[] args) {

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] vis = image;

        int[] delRow = new int[]{-1,0,+1,0};
        int[] delCol = new int[]{0,+1,0,-1};

        dfs(sr,sc,delRow,delCol,image,vis,color,image[sr][sc]);
        return vis;
    }

    private void dfs(int sr, int sc, int[] delRow, int[] delCol, int[][] image, int[][] vis, int color, int oldColor) {
        vis[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;

        for(int i=0 ; i<4; i++){
            int nrow = sr + delRow[i];
            int ncol = sc + delCol[i];
            if(nrow>=0 && nrow <n && ncol>=0 && ncol<m && image[nrow][ncol] == oldColor && vis[nrow][ncol] != color){
                dfs(nrow, ncol, delRow, delCol, image, vis, color, oldColor);
            }
        }
    }
}
