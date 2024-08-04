package org.dsa.Graph;

import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class G52MinimumHeightTree {
//    https://leetcode.com/problems/minimum-height-trees/description/
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};
        findMinHeightTrees(n, edges);
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return List.of(0);
        }
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[n];
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i] == 1){
                q.offer(i);
            }
        }
        while(n>2 ){
            int size = q.size();
            n=n-size;
            for(int i=0; i<size; i++){
                int node = q.poll();
                for(Integer adjNode : adjList.get(node)){
                    inDegree[adjNode]--;
                    if(inDegree[adjNode] == 1){
                        q.offer(adjNode);
                    }
                }
            }
        }

        ans.addAll(q);
        return ans;
    }
}
