package org.dsa.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class G48ArticulationPointInAGraph {
    public static void main(String[] args) {

    }
    private int timer = 0;
    public Set<Integer> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        // SC O(V+ 2E)
        Set<Integer> articulationPoint = new HashSet<>();
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
        dfsCritical(0 , -1, vis, adjList, time, lowTime, articulationPoint);
        return articulationPoint;
    }

    public void dfsCritical(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adjList, int[] time, int[] lowTime, Set<Integer> articulationPoint ){
        vis[node] = 1;
        time[node] = timer;
        lowTime[node] = timer;
        timer++;
        int child =0;
        for(Integer cNode : adjList.get(node)){
            //dont consider parent
            if(cNode == parent) continue;
            if(vis[cNode] != 1){
                dfsCritical(cNode, node, vis, adjList, time, lowTime, articulationPoint);
                // Getting the low time of adjcant Node when it has completed
                lowTime[node] = Math.min(lowTime[node], lowTime[cNode]);
                //if low time > greater means it is a bridge
                if(lowTime[cNode] >= time[node] && parent != -1){
                    articulationPoint.add(node);
                }
                child++;
            }
            else{
                // Getting the low time among all adjacent nodes .. even the once who are visited
                // Algo when we reach end .. to get low time of visited adjcent
                lowTime[node] = Math.min(lowTime[node], time[cNode]);
            }
        }
        if(child>1 && parent == -1){
            articulationPoint.add(node);
        }
    }
}
