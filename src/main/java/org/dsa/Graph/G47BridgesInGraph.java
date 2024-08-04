package org.dsa.Graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/critical-connections-in-a-network/description/
public class G47BridgesInGraph {
    private int timer = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        // SC O(V+ 2E)
        List<List<Integer>> bridges = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        // Creating adjList
        for(List<Integer> connection : connections){
            adjList.get(connection.get(0)).add(connection.get(1));
            adjList.get(connection.get(1)).add(connection.get(0));
        }

//        SC O(3V)
        int[] vis = new int[n];
        int[] time = new int[n];
        int[] lowTime = new int[n];
//        TC - O(V+ 2E)
        dfsCritical(0 , -1, vis, adjList, time, lowTime, bridges);
        return bridges;
    }

    public void dfsCritical(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adjList, int[] time, int[] lowTime, List<List<Integer>> bridges ){
        vis[node] = 1;
        time[node] = timer;
        lowTime[node] = timer;
        timer++;
        for(Integer cNode : adjList.get(node)){
            //dont consider parent
            if(cNode == parent) continue;
            if(vis[cNode] != 1){
                dfsCritical(cNode, node, vis, adjList, time, lowTime, bridges);
                // Getting the low time of adjcant Node when it has completed
                lowTime[node] = Math.min(lowTime[node], lowTime[cNode]);
                //if low time > greater means it is a bridge
                if(lowTime[cNode] > time[node]){
                    bridges.add(List.of(node, cNode));
                }
            }
            else{
                // Getting the low time among all adjacent nodes .. even the once who are visited
                // Algo when we reach end .. to get low time of visited adjcent
                lowTime[node] = Math.min(lowTime[node], lowTime[cNode]);
            }
        }
    }
}
