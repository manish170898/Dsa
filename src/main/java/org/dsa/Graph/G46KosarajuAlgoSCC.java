package org.dsa.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class G46KosarajuAlgoSCC {
    public static void main(String[] args) {

    }

    int kosaraju(int V, ArrayList<ArrayList<Integer>> adjList){
        // SC O(V) + O(V)
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        //TC O(V+E)
        for(int i=0; i<V; i++){
            if (vis[i] != 1){
                dfskosa(i, vis, st, adjList);
            }
        }
        //SC O(V+E)
        ArrayList<ArrayList<Integer>> revAdjList = new ArrayList<>();
        // TC O(V+E)
        for (int i=0; i<V; i++){
            revAdjList.add(new ArrayList<>());
        }
        for (int i=0; i<V; i++){
            for(int k: adjList.get(i)){
                revAdjList.get(k).add(i);
            }
        }
        int scc = 0;
        Arrays.fill(vis, 0);
        //TC O(V+E)
        while (!st.isEmpty()){
            Integer node = st.pop();
            if(vis[node] == 0){
                scc++;
                dfsrevkosa(node, vis, revAdjList);
            }
        }
        return scc;
    }

    private void dfsrevkosa(Integer node, int[] vis, ArrayList<ArrayList<Integer>> revAdjList) {
        vis[node] = 1;
        for (Integer i : revAdjList.get(node)){
            if(vis[i] != 1){
                dfsrevkosa(i,vis,revAdjList);
            }
        }
    }

    private void dfskosa(int i, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adjList) {
        vis[i] = 1;
        for(Integer node : adjList.get(i)){
            if(vis[node] != 1){
                dfskosa(node, vis, st, adjList);
            }
        }
        st.push(i);
    }
}
