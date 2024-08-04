package org.dsa.Graph;

import java.util.Arrays;

public class G43NumberOfIsland2 {
    public static void main(String[] args) {
//        int n = 4, m = 4;
//        int[][] queries = new int[][]{{0,2}, {1,0}, {3, 2}, {3, 0}, {1, 3}, {2, 2},{1, 1}};

        int n =8, m=6;
        int[][] queries = new int[][]{{6,3},{5,0},{3,5},{5,1},{3,1},{6,2},{1,0},{2,4},{1,2},{3,3},{7,2},{2,0},{0,1},{4,5},{2,5},{1,1},{4,2},{0,0},{6,4},{5,5},{7,5},{0,2},{4,1},{2,1},{6,0},{4,3},{3,2}};
        System.out.println(Arrays.toString(numberOfIslandII(n, m, queries, queries.length)));
    }
    public static int[] numberOfIslandII(int n, int m, int [][]queries, int q) {
        // Write your code here.
        int[] row = {-1,0,1,0};
        int[] col = {0,-1,0,1};
        int[][] vis = new int[n][m];
        G38DisjointSetBySize ds = new G38DisjointSetBySize(n*m);
        int noOfIslands = 0;
        int[] ans = new int[q];

        for(int qu =0; qu<q; qu++){
            int i = queries[qu][0];
            int j = queries[qu][1];
            if (vis[i][j] == 1){
                ans[qu] = noOfIslands;
                continue;
            }

            vis[i][j] = 1;
            noOfIslands++;
            for(int k=0; k<4; k++){
                int nRow = i + row[k];
                int nCol = j + col[k];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && vis[nRow][nCol] ==1){
                    int parentOfNode = ds.findPar(i*m + j);
                    int parentOfNeighbour = ds.findPar(nRow*m + nCol);
                    if(parentOfNeighbour != parentOfNode){
                        noOfIslands--;
                        ds.unionBySize(parentOfNode,parentOfNeighbour);
                    }
                }
            }
            ans[qu] = noOfIslands;
        }
        return ans;
    }
}
