package org.dsa.Graph;

import java.util.*;

public class G26DijkstraAlgorithm {
    public static void main(String[] args) {
    }

    static int[] dijkstraUsingPq(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<PairG> pq = new PriorityQueue<>((x,y) ->x.first-y.first);
        pq.offer(new PairG(0,S));

        int[] dis = new int[V];
        for (int i=0; i< V; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[S] = 0;

        while (!pq.isEmpty()){
            PairG pairG = pq.poll();
            int distance = pairG.first;
            int node = pairG.second;

            for(ArrayList<Integer> adjNodes : adj.get(node)){
                int adjNode = adjNodes.get(0);
                int adjDist = adjNodes.get(1);
                adjDist = adjDist + distance;
                if(adjDist < dis[adjNode]){
                    dis[adjNode] = adjDist;
                    pq.offer(new PairG(adjDist, adjNode));
                }
            }
        }
        return dis;
    }

    static int[] dijkstraUsingSet(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        TreeSet<PairG> set = new TreeSet<>((x,y)->x.first-y.first);
        set.add(new PairG(0,S));

        int[] dis = new int[V];
        for (int i=0; i< V; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[S] = 0;

        while (!set.isEmpty()){
            PairG pairG = set.pollFirst();
            int distance = pairG.first;
            int node = pairG.second;

            for(ArrayList<Integer> adjNodes : adj.get(node)){
                int adjNode = adjNodes.get(0);
                int adjDist = adjNodes.get(1);
                adjDist = adjDist + distance;
                if(adjDist < dis[adjNode]){
                    if (dis[adjDist] != Integer.MAX_VALUE){
                        set.remove(new PairG(dis[adjDist], adjNode));
                    }
                    dis[adjNode] = adjDist;
                    set.add(new PairG(adjDist, adjNode));
                }
            }
        }
        return dis;
    }
}
