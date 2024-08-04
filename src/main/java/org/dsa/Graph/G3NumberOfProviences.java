package org.dsa.Graph;

import java.util.ArrayList;

public class G3NumberOfProviences {

//    https://leetcode.com/problems/number-of-provinces/description/

    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] isConnected) {
        int[] vis = new int[isConnected.length];
        ArrayList<Integer> ans = new ArrayList<>();
        int count =0;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i =0; i< isConnected.length; i++){
            adj.add(new ArrayList<>());
        }

        for (int i=0; i< isConnected.length; i++){
            for (int j=0; j< isConnected.length; j++){
                if(i!=j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        for(int i=0; i< vis.length; i++){
            if (vis[i] != 1){
                count ++;
                dfs(ans, vis, adj, i);
            }
        }
        return count;
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
