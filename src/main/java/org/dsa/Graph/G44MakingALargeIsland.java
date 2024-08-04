package org.dsa.Graph;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/making-a-large-island/
public class G44MakingALargeIsland {
    public static void main(String[] args) {
        int[][] grid = {{1,0},{0,1}};
        System.out.println(largestIsland(grid));
    }

    public static int largestIsland(int[][] grid) {
        int[] rRow = {-1,0,1,0};
        int[] rCol = {0,-1,0,1};
        int n = grid.length;
        G38DisjointSetBySize ds = new G38DisjointSetBySize(n*n);
        //Created Disjoint set
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    for(int k=0; k<4; k++){
                        int row = i +rRow[k];
                        int col = j +rCol[k];
                        if(row>=0 && row<n && col>=0 && col<n && grid[row][col] == 1){
                            ds.unionBySize((i*n + j), (row*n + col));
                        }
                    }
                }
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    Set<Integer> set = new HashSet<>();
                    for(int k=0; k<4; k++){
                        int row = i +rRow[k];
                        int col = j +rCol[k];
                        if(row>=0 && row<n && col>=0 && col<n && grid[row][col] == 1){
                            int parent = ds.findPar(row*n + col);
                            set.add(parent);
                        }
                    }
                    int max = 0;
                    for(int parent: set){
                        max += ds.size[parent];
                    }
                    max++;
                    if(max>ans){
                        ans = max;
                    }
                }
            }
        }
        for(int c=0; c< n*n; c++){
            ans = Math.max(ans, ds.size[ds.findPar(c)]);
        }
        return ans;
    }
}
