package org.dsa.Graph;

import java.util.PriorityQueue;
public class G39KruskalsAlgorithm {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1, 2, 6}, {2, 3, 5}, {3, 4, 4}, {1, 4, 1}, {1, 3, 2}, {3, 5, 3}};
        System.out.println(kruskalMST(n, edges));
    }

    public static int kruskalMST(int n,int [][]edges){
        G38DisjointSetBySize disjointSetBySize = new G38DisjointSetBySize(n);
        PriorityQueue<PairK> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        int mst = 0;
//        TC - nlogn
        // or you can just sort using sort method on weights
        for(int[] edge: edges){
            pq.offer(new PairK(edge[2], edge[0], edge[1]));
        }


//        TC - n(4alpha*2)
        while(!pq.isEmpty()){
            PairK pair = pq.poll();
            int weight = pair.weight;
            int nodeA = pair.nodeA;
            int nodeB = pair.nodeB;

            int parA = disjointSetBySize.findPar(nodeA);
            int parB = disjointSetBySize.findPar(nodeB);
            if(parA != parB){
                disjointSetBySize.unionBySize(nodeA, nodeB);
                mst+=weight;
            }
        }
        return mst;
    }
}
class PairK{
    int weight;
    int nodeA;
    int nodeB;
    public PairK(int weight, int nodeA, int nodeB) {
        this.weight = weight;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }
}