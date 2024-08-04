package org.dsa.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class G15TopologicalSortDfs {
    public static void main(String[] args) {

    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[V];

        for(int i=0; i<V; i++) {
            if (vis[i] == 0) {
                dfsTopo(i, vis, adj, stack);
            }
        }
        for (int i=0; i<V; i++){
            ans[i] = stack.pop();
        }
        return ans;
    }

    private static void dfsTopo(int i, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        vis[i] = 1;
        for (int node: adj.get(i)) {
            if(vis[node]==0) {
                dfsTopo(node, vis, adj, stack);
            }
        }
        stack.push(i);
    }
}
