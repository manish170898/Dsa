package org.dsa.Graph;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class PairG{
    int first;
    int second;

    public PairG(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairG pairG = (PairG) o;
        return first == pairG.first && second == pairG.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
public class G4NumberOfIlands {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int count =0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        for (int i=0 ; i<n; i++){
            for (int j=0; j<m; j++){
                if(grid[i][j] =='1' && vis[i][j] != 1){
                    count++;
                    dfs(i, j, grid, vis);
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, char[][] grid, int[][] vis) {
        vis[i][j] = 1;
        Queue<PairG> queue = new LinkedList<>();
        queue.offer(new PairG(i,j));
        int n = grid.length;
        int m = grid[0].length;
        while (!queue.isEmpty()){
            PairG p = queue.poll();
            int row = p.first;
            int col = p.second;
            for(int delRow = -1; delRow<= 1; delRow++){
                for(int delCol = -1; delCol<= 1; delCol++){
                    int nrow = row + delRow;
                    int ncol = col + delCol;
                    if (nrow>=0 && nrow <n && ncol>=0 && ncol<m && grid[nrow][ncol] == '1' && vis[nrow][ncol] != 1){
                        vis[nrow][ncol] = 1;
                        queue.add(new PairG(nrow, ncol));
                    }
                }
            }
        }
    }
}
