package org.dsa.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class G32NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
       int n = 7;
       int[][] roads = new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};

       System.out.println(countPaths(n,roads));

    }

    public static int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<PairL>> adjList = new ArrayList<>();
        int MOD = (int)(1e9 +7);
        int[] ways = new int[n];
        long[] dis = new long[n];
        for(int i=0 ; i<n; i++){
            adjList.add(new ArrayList<>());
            dis[i] = Long.MAX_VALUE/2;
            ways[i] = 0;
        }
        dis[0] = 0;
        ways[0] = 1;

        for(int[] road : roads){
            adjList.get(road[0]).add(new PairL(road[1], (long)road[2]));
            adjList.get(road[1]).add(new PairL(road[0], (long)road[2]));
        }

        PriorityQueue<PairL> pq = new PriorityQueue<>((x, y) -> Long.compare( x.distance,y.distance));
        pq.offer(new PairL(0,(long)0));

        while(!pq.isEmpty()){
            PairL pair = pq.poll();
            Long dist = pair.distance;
            Integer node = pair.node;
            for(PairL cPair : adjList.get(node)){
                Long cDist = cPair.distance;
                Integer cNode = cPair.node;
                if(cDist + dist < dis[cNode]){
                    cDist = dist + cDist;
                    dis[cNode] = cDist;
                    pq.offer(new PairL(cNode, cDist));
                    ways[cNode] = ways[node];
                }
                else if(cDist + dist == dis[cNode]){
                    ways[cNode] = (ways[cNode] + ways[node])%MOD;
                }
            }
        }
        return ways[n-1]%MOD;
    }
}

class PairL{
    int node;
    Long distance;
    public PairL(int node, Long distance){
        this.node = node;
        this.distance = distance;
    }
}
