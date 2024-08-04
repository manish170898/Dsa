package org.dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class G23ShortestPathUndirectedGraph {
    public static void main(String[] args) {

    }

    public static int[] shortestPath(int n, int [][]edges, int src) {
        // Write your code here
        int[] ans= new int[n];
        ArrayList<ArrayList<PairG>> adjList = new ArrayList<>();
        Queue<PairG> q = new LinkedList<>();

        //Creating AdjList
        for (int i =0; i<n; i++){
            adjList.add(new ArrayList<>());
            ans[i] = Integer.MAX_VALUE;
        }
        for (int i =0; i<n; i++){
            adjList.get(edges[i][0]).add(new PairG(edges[i][1], edges[i][2]));
        }

        bfsShort(0, q, adjList, ans);
        return ans;
    }

    private static void bfsShort(int i, Queue<PairG> q, ArrayList<ArrayList<PairG>> adjList, int[] ans) {
        ans[i] = 0;
        q.offer(new PairG(i, 0));
        while(!q.isEmpty()){
            PairG pairG = q.poll();
            int val = pairG.first;
            int dis = ans[val];
            for (PairG pair: adjList.get(val)){
                ans[pair.first] = Math.min(ans[pair.first], dis + pair.second);
                q.offer(new PairG(pairG.first, ans[pair.first]));
            }
        }
    }
}
