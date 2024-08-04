package org.dsa.Graph;

import java.util.Map;
import java.util.PriorityQueue;

public class G29PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(heights));
    }
//    https://leetcode.com/problems/path-with-minimum-effort/

    public static int minimumEffortPath(int[][] heights) {
        int[] rdef = {-1,0,+1,0};
        int[] cdef = {0,-1,0,+1};
        int row = heights.length;
        int col = heights[0].length;
        int[][] dis = new int[row][col];
        for (int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[0][0] = 0;

        PriorityQueue<PairF> q = new PriorityQueue<>((x,y)-> x.third - y.third);
        q.offer(new PairF(0,0,0));

        while (!q.isEmpty()){
            PairF pair = q.poll();
            int r = pair.first;
            int c = pair.second;
            int effort = pair.third;
            if(r == row-1 && c == col-1){
                return effort;
            }
            for(int k=0 ; k<4; k++){
                int nrow = r + rdef[k];
                int ncol = c + cdef[k];
                if(nrow>=0 && nrow<row && ncol>=0 && ncol<col && Math.max(effort, Math.abs(heights[r][c] - heights[nrow][ncol])) < dis[nrow][ncol]){
                    dis[nrow][ncol] = Math.abs(heights[r][c] - heights[nrow][ncol]);
                    q.offer(new PairF(nrow, ncol, Math.max(effort, Math.abs(heights[r][c] - heights[nrow][ncol]))));
                }
            }
        }
        return -1;
    }
}
