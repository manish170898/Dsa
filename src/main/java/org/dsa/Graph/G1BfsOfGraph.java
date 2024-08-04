package org.dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
//Input:
//        V = 5, E = 4
//        adj = {{1,2,3},{},{4},{},{}}
//
//
//        Output:
//        0 1 2 3 4
//        Explanation:
//        0 is connected to 1 , 2 , 3.
//        2 is connected to 4.
//        so starting from 0, it will go to 1 then 2
//        then 3. After this 2 to 4, thus bfs will be
//        0 1 2 3 4.
// SC -O(3N)  TC - O(N) + O(2E)
public class G1BfsOfGraph {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            ArrayList<Integer> list = adj.get(node);
            for (Integer n: list){
                if(vis[n] != 1){
                    vis[n] = 1;
                    q.offer(n);
                }
            }
        }
        return ans;
    }
}
