package org.dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G50FindAllGroupsOfFarmland {
//    https://leetcode.com/problems/find-all-groups-of-farmland/description/
    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        int[][] vis = new int[n][m];
        List<int[]> ans = new ArrayList<>();
        int[] ds = new int[4];
        Queue<PairA> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j] == 1 && vis[i][j] != 1){
                    ds[0] = i;
                    ds[1] = j;
                    queue.offer(new PairA(i,j));
                    vis[i][j] = 1;
                    bfs(ds, queue, land, vis);
                    ans.add(ds);
                    ds = new int[4];
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public void bfs(int[] ds, Queue<PairA> queue, int[][] land,  int[][] vis){
        int[] row = {1,0};
        int[] col = {0,1};
        while(!queue.isEmpty()){
            PairA pair = queue.poll();
            int i = pair.first;
            int j = pair.second;
            for(int k=0; k<2; k++){
                int nRow = i + row[k];
                int nCol = j + col[k];
                if(nRow < land.length && nCol < land[0].length){
                    if(land[nRow][nCol] == 1 && vis[nRow][nCol] != 1){
                        queue.offer(new PairA(nRow,nCol));
                        vis[nRow][nCol] = 1;
                    }
                }
            }
            if(queue.size() == 0){
                ds[2] = i;
                ds[3] = j;
            }
        }
    }
}

class PairA{
    int first;
    int second;
    public PairA(int first, int second){
        this.first = first;
        this.second = second;
    }
}
