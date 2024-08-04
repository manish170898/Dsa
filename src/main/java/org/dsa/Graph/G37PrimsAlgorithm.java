package org.dsa.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class G37PrimsAlgorithm {
    public static void main(String[] args) {
    }

    public static int minimumSpanningTree(ArrayList<ArrayList<ArrayList<Integer>>> edges, int n) {
        //Your code goes here using PRims Algorithm
        PriorityQueue<PairG> pq = new PriorityQueue<>((x,y) -> x.second - y.second);
        int[] vis = new int[n];
        int sum =0;

        pq.offer(new PairG(0,0));
//        E log E + E log E = E logE
        while(!pq.isEmpty()){

            // logE
            PairG pair = pq.poll();
            int node = pair.first;
            int dis = pair.second;

            if(vis[node] == 1){
                continue;
            }
            vis[node] = 1;
            sum = sum + dis;
//            E LogE
            for(int i=0; i< edges.get(node).size(); i++){
                int childNode = edges.get(node).get(i).get(0);
                int childDis = edges.get(node).get(i).get(1);
                if(vis[childNode] == 0){
                    pq.offer(new PairG(childNode, childDis));
                }
            }
        }

        return sum;
    }
}
