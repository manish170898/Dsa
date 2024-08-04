package org.dsa.Recursion;

import java.util.ArrayList;

public class R22MColoringProblem {
    public static void main(String[] args) {

    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] vis = new int[n];

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[0].length; j++){
                if(graph[i][j]){
                    adjList.get(i).add(j);
                }
            }
        }

         return rec(0, m, n, vis, adjList);
    }

    public boolean rec(int node, int m, int n, int[] vis, ArrayList<ArrayList<Integer>> adjList){
        if(node == n){
            return true;
        }
        for(int i=1; i<=m; i++){
            if(isValid(node, i, m,n,vis,adjList)){
                vis[node] = i;
                if(rec(node + 1, m,n,vis,adjList)) return true;
                vis[node] = 0;
            }
        }
        return false;
    }

    public boolean isValid(int node, int color, int m, int n, int[] vis, ArrayList<ArrayList<Integer>> adjList){
        for(Integer cNodes : adjList.get(node)){
            if(vis[cNodes] == color){
                return false;
            }
        }
        return true;
    }

}
