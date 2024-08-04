package org.dsa.BinarySearch;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;
// PRIORITY QUEUE APPROACH
public class B23MinimizeMaxDistanceToGasStation {
    public static void main(String[] args) {
        int[] stations = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10};
        int k = 9;

        System.out.println(findSmallestMaxDist(stations, k));
    }
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
//        PriorityQueue<PairGas> pq = new PriorityQueue<>((a, b) -> (Double.compare(a.distance, b.distance)));
        PriorityQueue<PairGas> pq = new PriorityQueue<PairGas>(new Comparator<PairGas>(){
            public int compare(PairGas node1, PairGas node2){
                if(node2.distance>node1.distance){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });
        int[] howMany = new int[stations.length];

        for(int i=0; i<stations.length-1; i++){
            pq.offer(new PairGas(stations[i+1] - stations[i], i));
        }

        while(k != 0){
            PairGas pair = pq.poll();
            int secIndex = pair.index;
            howMany[secIndex]++;
            double initDiff = stations[secIndex+1] - stations[secIndex];
            double newDiff = initDiff/(double)(howMany[secIndex]+1);
            k--;
            pq.offer(new PairGas(newDiff, secIndex));
        }
        return pq.poll().distance;
    }






//BS APPROACH
    public static int noOfGasStationsBetween(int[] arr, double dist) {
        int cnt = 0, n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            double stationsInBetween = (arr[i + 1] - arr[i]) / dist;
            cnt += stationsInBetween;
        }

        return cnt;
    }

    public static double findSmallestMaxDistBS(int[] arr, int k) {
        int n = arr.length;
        double maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) maxi =
                Math.max(maxi, (double) (arr[i + 1] - arr[i]));

        double low = 0, high = maxi, diff = 1e-6; // 10^-6
        while(high - low > diff) {
            double mid = low + (high - low) / 2;
            if(noOfGasStationsBetween(arr, mid) <= k)
                high=mid;
            else
                low=mid;
        }

        return high;
    }
}

class PairGas{
    double distance;
    int index;
    public PairGas(double distance, int index){
        this.distance = distance;
        this.index = index;
    }
}





