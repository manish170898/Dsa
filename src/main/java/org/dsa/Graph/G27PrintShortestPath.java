package org.dsa.Graph;

import java.util.*;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class G27PrintShortestPath {
    //Shorttest Path from node 1 to N  from 1st to last node
    public static void main(String[] args) {
        int n = 5, m= 6;
        int[][] edges = new int[][]{{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}};

        System.out.println(shortestPath(n,m,edges));
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]){
        ArrayList<ArrayList<PairG>> adjList = new ArrayList<>();

        for (int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            adjList.get(edge[0]).add(new PairG(edge[1], edge[2]));
            adjList.get(edge[1]).add(new PairG(edge[0], edge[2]));
        }

        int[] dis = new int[n+1];
        int[] parent = new int[n+1];

        for(int i=0; i<n+1; i++){
            dis[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }

        PriorityQueue<PairG> pq = new PriorityQueue<>((x,y)->x.first- y.first);
        pq.offer(new PairG(0,1));
        dis[1]=0;

        while (!pq.isEmpty()){
            PairG pairG = pq.poll();
            int dist = pairG.first;
            int node = pairG.second;
            for(PairG childNodes :adjList.get(node)){
                int distChild = childNodes.second;
                int childNode =  childNodes.first;
                if(dis[childNode] > dist+distChild){
                    dis[childNode] = dist + distChild;
                    parent[childNode] = node;
                    pq.offer(new PairG(dis[childNode], childNode));
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(dis[n] == Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        }
        int node = n;
        while (parent[node] != node){
            ans.add(node);
            node = parent[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        ans.add(0,dis[n]);
        return ans;
    }
}