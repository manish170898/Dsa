package org.dsa.Graph;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
public class G45MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(removeStones(stones));
    }

    public static int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int[] stone : stones){
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        G38DisjointSetBySize ds = new G38DisjointSetBySize(maxRow + maxCol +1);
        Set<Integer> s = new HashSet<>();
        for(int[] stone: stones){
            int row = stone[0];
            int col = stone[1] + maxRow + 1;
            ds.unionBySize(row,col);
            s.add(row);
            s.add(col);
        }
        int count = 0;
        for(Integer i : s){
            if(ds.findPar(i) == i){
                count++;
            }
        }
        return stones.length - count;
    }
}
