package org.dsa.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
//https://leetcode.com/problems/network-delay-time/
public class G36NetworkDelayTime {
    public static void main(String[] args) {

        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        System.out.println(networkDelayTime(times,n,k));
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<PairG>> adjList = new ArrayList<>();
        int[] dis = new int[n+1];
        for(int i=0; i<= n; i++){
            adjList.add(new ArrayList<>());
            dis[i] = (int)(1e9);
        }
        dis[k] = 0;

        for(int[] time : times){
            adjList.get(time[0]).add(new PairG(time[1], time[2]));
        }

        PriorityQueue<PairG> q = new PriorityQueue<>((x,y) -> x.second - y.second);
        q.offer(new PairG(k,0));

        while(!q.isEmpty()){
            PairG pair = q.poll();
            int node = pair.first;
            int dist = pair. second;
            for(PairG childPair : adjList.get(node)){
                int childNode = childPair.first;
                int childDist = childPair.second;
                if(dist + childDist < dis[childNode]){
                    dis[childNode] = dist + childDist;
                    q.offer(new PairG(childNode, dis[childNode]));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            if(dis[i] == (int)(1e9)){
                return -1;
            }
            else if(dis[i] > max){
                max = dis[i];
            }
        }
        return max;
    }
}
