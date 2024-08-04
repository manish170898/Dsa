package org.dsa.Graph;

import java.util.ArrayList;

public class G13CycleInDirectedGraphDfs {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,0}};
//        findOrder(2,arr);
    }
    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        int[] vis = new int[n];
        int[] visPath = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                if(dfsDetect(i,edges, vis, visPath)) return true;
            }
        }
        return false;
    }

    private static boolean dfsDetect(int i, ArrayList<ArrayList<Integer>> edges, int[] vis, int[] visPath) {
        vis[i] = 1;
        visPath[i] = 1;
        for (Integer node: edges.get(i)){
            if (vis[node] == 0){
                if(dfsDetect(node, edges,vis,visPath)) return true;
            }
            else if(visPath[node] == 1){
                return true;
            }
        }
        visPath[i] = 0;
        return false;
    }
}
