package org.dsa.Recursion;

import java.util.ArrayList;

public class R20RatInAMaze {
    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};

//        System.out.println(findPath(m, 4));

        String s = "123456";

        System.out.println(s.substring(6,6));
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int[][] vis = new int[n][n];

        if(m[0][0] == 0){
            return new ArrayList<String>();
        }
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(0, 0, list, vis, m, n, sb);
        return list;
    }

    public static void dfs(int i, int j, ArrayList<String> list, int[][] vis, int[][] m, int n, StringBuilder sb){
        int[] row = {1,0,-1,0};
        int[] col = {0,1,0,-1};
        String[] dir = {"D","R","U","L"};
        vis[i][j] = 1;
        if(i == n-1 && j == n-1){
            list.add(sb.toString());
            return;
        }

        for(int k=0; k<4; k++){
            int nRow = i + row[k];
            int nCol = j + col[k];

            if(nRow>=0 && nCol>=0 && nRow<n && nCol<n && m[nRow][nCol] == 1 && vis[nRow][nCol] != 1){
                vis[nRow][nCol] = 1;
                sb.append(dir[k]);
                dfs(nRow, nCol, list, vis, m, n, sb);
                vis[nRow][nCol] = 0;
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }
}
