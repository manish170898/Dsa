package org.dsa.Graph;

import java.util.ArrayList;

public class G2DfsOfGraph {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[V];
        dfs(ans, vis, adj, 0);
        return ans;
    }

    public void dfs(ArrayList<Integer> ans, int[] vis, ArrayList<ArrayList<Integer>> adj, int node){
        ans.add(node);
        vis[node] =1;
        for (Integer n : adj.get(node)){
            if(vis[n] != 1){
                dfs(ans, vis, adj, n);
            }
        }
    }
}
