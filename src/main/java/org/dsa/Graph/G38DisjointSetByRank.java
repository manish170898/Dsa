package org.dsa.Graph;

public class G38DisjointSetByRank {
    private int[] parent;
    private int[] rank;
    public G38DisjointSetByRank(int N){
      this.parent = new int[N+1];
      this.rank = new int[N+1];
      for (int i=0; i<N; i++){
          parent[i] = i;
      }
    }
    public void unionByRank(int nodeA, int nodeB){
        int parentA = findPar(nodeA);
        int parentB = findPar(nodeB);
        if(parentA == parentB) return;
        if(rank[parentA] > rank[parentB]){
            parent[parentB] = parentA;
        }
        else if (rank[parentA] < rank[parentB]){
            parent[parentA] = parentB;
        }
        else{
            parent[parentA] = parentB;
            rank[parentB]++;
        }
    }
    public int findPar(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findPar(parent[node]);
    }
}
