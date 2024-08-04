package org.dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G7DetectACycleInUndirectedGraph {
    public static void main(String[] args) {

    }

    public static boolean cycleBfs(int V, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[V];
        for(int i =1 ; i< V; i++){
            if(vis[i] != 1){
                if(detectByBfs(i, vis, adj)) return true;
            }
        }
        return false;
    }

    private static boolean detectByBfs(int src, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[src] = 1;
        Queue<PairG> queue = new LinkedList<>();
        // -1 as it has no previous this is the starting point
        queue.offer(new PairG(src, -1));
        while (!queue.isEmpty()){
            PairG pair = queue.poll();
            int currentNode = pair.first;
            int prevNode = pair.second;

            for(Integer node: adj.get(currentNode)){
                if(vis[node] != 1 ){
                    queue.offer(new PairG(node, currentNode));
                }
                else if(node != prevNode){
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleDfs(int V, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[V];
        int src = 1;
        for(int i =1 ; i< V; i++){
            if(vis[i] != 1){
                if(detectByDfs(new PairG(i, -1), vis, adj)) return true;
            }
        }
        return false;
    }

    private static boolean detectByDfs(PairG pair, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        int node = pair.first;
        int parent = pair.second;
        vis[node] = 1;
        for (Integer newNode : adj.get(node)){
            if (vis[node] != 1){
                if(detectByDfs(new PairG(newNode, node), vis, adj)){
                    return true;
                }
            }
            else if(newNode != parent){
                return true;
            }
        }
        return false;
    }
}
