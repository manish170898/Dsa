package org.dsa.Graph;

import java.util.*;


//https://leetcode.com/problems/number-of-distinct-islands-ii/description/

//https://www.codingninjas.com/studio/problems/distinct-islands_630460?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
public class G11DistinctIslands {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(distinctIsland(matrix, 5,5));
    }

    public static int distinctIsland(int [][] arr, int n, int m)
    {
        int[][] vis = new int[n][m];

        Set<List<PairG>> set = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               if(arr[i][j] == 1 && vis[i][j] != 1){
                   List<PairG> island = new ArrayList<>();
                   PairG baseCoordinate = new PairG(i,j);
                   island.add(new PairG(i-baseCoordinate.first, j-baseCoordinate.second));
                   vis[i][j] = 1;
                   dfsDn(i,j,arr,vis, island, baseCoordinate);
                   set.add(island);
               }
            }
        }
        return set.size();
    }

    private static void dfsDn(int i, int j, int[][] arr, int[][] vis, List<PairG> island, PairG baseCoordinate) {
        int n = arr.length;
        int m = arr[0].length;
        int[] delRow = new int[]{-1,0,+1,0};
        int[] delCol = new int[]{0,+1,0,-1};
        for(int k=0 ; k<4; k++){
            int nrow = i + delRow[k];
            int ncol = j + delCol[k];
            if(nrow>=0 && nrow <n && ncol>=0 && ncol<m && arr[nrow][ncol] == 1 && vis[nrow][ncol]!=1){
                vis[nrow][ncol] = 1;
                island.add(new PairG(nrow-baseCoordinate.first, ncol-baseCoordinate.second));
                dfsDn(nrow,ncol,arr,vis, island, baseCoordinate);
            }
        }
    }
}
