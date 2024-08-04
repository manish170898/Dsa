package org.dsa.Graph;

import java.util.HashMap;
//https://leetcode.com/problems/swim-in-rising-water/
public class G49SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int n = grid.length;

        if (n == 1)
            return 0;

        G38DisjointSetBySize ds = new G38DisjointSetBySize(n * n);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                map.put(grid[i][j], new int[]{i, j});

        int time = 0;

        while (ds.findPar(0) != ds.findPar(n * n - 1)) {
            int[] node = map.get(time);
            int x = node[0];
            int y = node[1];
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};

            for (int i = 0; i < 4; i++) {
                int nrow = x + dx[i];
                int ncol = y + dy[i];

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < n && grid[nrow][ncol] <= time)
                    ds.unionBySize(nrow * n + ncol, x * n + y);
            }

            time++;
        }

        return time - 1;
    }
}
