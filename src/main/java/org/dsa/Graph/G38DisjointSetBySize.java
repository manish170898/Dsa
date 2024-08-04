package org.dsa.Graph;

import java.util.Arrays;

public class G38DisjointSetBySize {
    public int[] parent;
    public int[] size;
    public G38DisjointSetBySize(int N){
        this.parent = new int[N+1];
        this.size = new int[N+1];
        Arrays.fill(this.size, 1);
        for (int i=0; i<=N; i++){
            parent[i] = i;
        }
    }
    public void unionBySize(int nodeA, int nodeB){
        int parentA = findPar(nodeA);
        int parentB = findPar(nodeB);
        if(parentA == parentB) return;
        if(size[parentA] > size[parentB]){
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
        }
        else{
            parent[parentA] = parentB;
            size[parentB] += size[parentA];
        }
    }
    public int findPar(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findPar(parent[node]);
    }
}