package org.dsa.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class G6RottenOranges {

    public static void main(String[] args) {
        int[][] grind = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grind));
    }
    public static int orangesRotting(int[][] grid) {
        int[] delRow = new int[]{-1,0,+1,0};
        int[] delCol = new int[]{0,+1,0,-1};

        int n = grid.length;
        int m = grid[0].length;
        int time=0;
        Queue<PairC> queue = new LinkedList<>();

        int[][] vis = new int[n][m];

        for (int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    queue.offer(new PairC(i,j,time));
                    vis[i][j] = 1;
                }
            }
        }
        while (!queue.isEmpty()){
            PairC PairC = queue.poll();
            int row = PairC.first;
            int col = PairC.second;
            int ctime = PairC.time;
            for(int i=0; i<4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow>=0 && nrow <n && ncol>=0 && ncol<m && grid[nrow][ncol] == 1 && vis[nrow][ncol] != 1){
                    time = ctime+1;
                    queue.offer(new PairC(nrow,ncol,time));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        for (int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && vis[i][j] != 1){
                    return -1;
                }
            }
        }

        return time;
    }
}

class PairC{
    int first;
    int second;
    int time;

    public PairC(int first, int second, int time) {
        this.first = first;
        this.second = second;
        this.time = time;
    }
}

