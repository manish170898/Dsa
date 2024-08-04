package org.dsa.Graph;

import java.util.List;

public class G33BellemnFordAlgo {
    public static void main(String[] args) {

    }

    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        // Write your code here.
        int[] dis = new int[n];

        for(int i=0; i<n; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;

        for (int i=0; i<n-1; i++){
            for(List<Integer> edge : edges){
                Integer nodeA = edge.get(0);
                Integer nodeB = edge.get(1);
                Integer weight = edge.get(2);
                if(dis[nodeA] != Integer.MAX_VALUE && dis[nodeB] > dis[nodeA] + weight){
                    dis[nodeB] = dis[nodeA] + weight;
                }
            }
        }

        for(List<Integer> edge : edges){
            Integer nodeA = edge.get(0);
            Integer nodeB = edge.get(1);
            Integer weight = edge.get(2);
            if(dis[nodeA] != Integer.MAX_VALUE && dis[nodeB] > dis[nodeA] + weight){
                int[] loop = new int[1];
                loop[0] = -1;
                return loop;
            }
        }
        return dis;
    }
}
