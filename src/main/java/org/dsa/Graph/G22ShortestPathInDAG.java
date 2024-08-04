package org.dsa.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class G22ShortestPathInDAG {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1, 2}, {1, 2, 3}, {0, 2, 6}};
        shortestPathInDAG(3,3,edges);
    }
// N vertices and M weighted edges
    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
        // Write your code here
        int[] vis= new int[n];
        int[] ans= new int[n];
        ArrayList<ArrayList<PairG>> adjList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        //Creating AdjList
        for (int i =0; i<n; i++){
            adjList.add(new ArrayList<>());
            ans[i] = Integer.MAX_VALUE;
        }
        for (int i =0; i<n; i++){
            adjList.get(edges[i][0]).add(new PairG(edges[i][1], 1));
            adjList.get(edges[i][1]).add(new PairG(edges[i][0], 1));
        }

        // Doing Topo Sort
        for (int i=0; i<n; i++){
            if(vis[i] == 0){
                vis[i] = 1;
                dfsTopoSP(i, stack, adjList, vis);
            }
        }

        //Calculating SHortest Path
//        as we have to calculate distance from 0
        ans[0] = 0;
        while(!stack.isEmpty()){
            Integer node = stack.pop();
            Integer distance = ans[node];
            for (PairG neighbour: adjList.get(node)){
                Integer val = neighbour.first;
                Integer di = neighbour.second;
                di = distance+ di;
                ans[val] = Math.min(di, ans[val]);
            }
        }
        return ans;
    }
    private static void dfsTopoSP(int i, Stack<Integer> stack, ArrayList<ArrayList<PairG>> adjList, int[] vis) {
        for (PairG nodes : adjList.get(i)){
            Integer node = nodes.first;
            if(vis[node] == 0){
                vis[node] = 1;
                dfsTopoSP(node, stack, adjList, vis);
            }
        }
        stack.push(i);
    }
}
