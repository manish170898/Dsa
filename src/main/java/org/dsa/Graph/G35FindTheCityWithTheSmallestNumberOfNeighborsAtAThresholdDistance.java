package org.dsa.Graph;

import java.util.Arrays;

public class G35FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

//    https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;

        System.out.println(findTheCity(n,edges,distanceThreshold));

    }
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] adjMatrix = new int[n][n];
        for(int[] e:adjMatrix) Arrays.fill(e,(int)(1e9));
        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            adjMatrix[from][to] = weight;
            adjMatrix[to][from] = weight;
            adjMatrix[to][to] = 0;
            adjMatrix[from][from] = 0;
        }

        for(int v=0; v<n; v++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][v] + adjMatrix[v][j]);
                }
            }
        }

        int currMax = distanceThreshold + 1;
        int city = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int thre = 0;
            for(int j=0; j<n; j++){
                if(adjMatrix[i][j] <= distanceThreshold){
                    thre++;
                }
            }
            if(thre <= currMax){
                currMax = thre;
                city = i;
            }
        }

        return city;
    }
}
