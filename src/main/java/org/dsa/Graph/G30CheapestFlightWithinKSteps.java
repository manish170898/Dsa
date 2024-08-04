package org.dsa.Graph;

import java.util.*;

public class G30CheapestFlightWithinKSteps {

//    https://leetcode.com/problems/cheapest-flights-within-k-stops/
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<PairG>> adjList= new ArrayList<>();
        int[] dis = new int[n];
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;
        for(int[] flight: flights){
            adjList.get(flight[0]).add(new PairG(flight[1],flight[2]));
        }
        Queue<PairF> q = new LinkedList<>();
        q.offer(new PairF(src,0,0));

        while(!q.isEmpty()){
            PairF pair = q.poll();
            int fli = pair.first;
            int dist = pair.second;
            int fliK = pair.third;
            if(fliK > k){
                continue;
            }
            for(PairG destPair : adjList.get(fli)){
                int destFli = destPair.first;
                int destDis = destPair.second;
                if(dist + destDis < dis[destFli] && fliK <=k){
                    destDis = dist + destDis;
                    dis[destFli] = destDis;
                    q.offer(new PairF(destFli, destDis, fliK+1));
                }
            }
        }
        if(dis[dst] != Integer.MAX_VALUE){
            return dis[dst];
        }
        return -1;
    }

}

