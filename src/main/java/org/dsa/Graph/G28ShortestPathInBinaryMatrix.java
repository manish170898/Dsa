package org.dsa.Graph;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class G28ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1},{1,0}};
        int[][] grid1 = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid1));
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1){
            return -1;
        }
        if(grid.length == 1){
            return 1;
        }
        int vis[][] = new int[grid.length][grid.length];
        Queue<PairF> q = new LinkedList<>();
        q.add(new PairF(0,0,1));
        vis[0][0] = 1;
        while(!q.isEmpty()){
            PairF pair = q.poll();
            int i = pair.first;
            int j = pair.second;
            int count = pair.third;
            for(int k=-1; k<2; k++){
                for(int l=-1; l<2; l++){
                    int nRow = i+k;
                    int nCol = j+l;
                    if(nRow>= 0 && nRow< grid.length && nCol >= 0 && nCol< grid.length && vis[nRow][nCol] != 1 && grid[nRow][nCol] == 0){
                        if(nRow == grid.length-1 && nCol == grid.length-1){
                            return count+1;
                        }
                        vis[nRow][nCol] = 1;
                        q.offer(new PairF(nRow, nCol, count+1));
                    }
                }
            }
        }
        return -1;
    }
}

class PairF{
    int first;
    int second;
    int third;

    public PairF(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
