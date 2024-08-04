package org.dsa.Graph;

import java.util.LinkedList;
import java.util.Queue;


//https://leetcode.com/problems/is-graph-bipartite/
public class G12BipartiteGraph {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] arr1 = new int[][]{{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        isBipartiteBfs(arr1);
    }

    public static boolean isBipartiteBfs(int[][] graph) {
        int[] vis = new int[graph.length];

        // we will color 1 and -1
        for(int i=0; i<graph.length; i++){
            if(vis[i] == 0){
                if(!bfsBip(i,graph, vis)) return false;
            }
        }
        return true;
    }

    private static boolean bfsBip(int i, int[][] adj, int[] vis) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        vis[i] = -1;
        while (!queue.isEmpty()){
            Integer currNode = queue.poll();
            Integer currColor = vis[currNode];
            for (Integer node : adj[currNode]){
                if(vis[node] == 0){
                    if(currColor == -1) vis[node] = 1;
                    else vis[node] = -1;
                    queue.offer(node);
                }
                else if(vis[node] == currColor) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartiteDfs(int[][] graph) {
        int[] vis = new int[graph.length];

        // we will color 1 and -1
        for(int i=0; i<graph.length; i++){
            if(vis[i] == 0){
                vis[i] = -1;
                if(!dfsBip(i,graph, vis)) return false;
            }
        }
        return true;
    }

    private static boolean dfsBip(int i, int[][] graph, int[] vis) {
        for(Integer node: graph[i]){
            if(vis[node] == 0){
                if(vis[i] == -1)vis[node] = 1;
                else vis[node] = -1;
                if(!dfsBip(node,graph,vis)) return false;
            }
            else if (vis[node] == vis[i]){
                return false;
            }
        }
        return true;
    }


}
