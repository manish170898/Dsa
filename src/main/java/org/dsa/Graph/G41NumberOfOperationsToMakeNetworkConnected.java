package org.dsa.Graph;
//https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
public class G41NumberOfOperationsToMakeNetworkConnected {
    public static void main(String[] args) {

    }

    public int makeConnected(int n, int[][] connections) {
        G38DisjointSetBySize ds = new G38DisjointSetBySize(n);
        int noOfWires = 0;
        int noOfWiresNeeded = -1;
        for(int[] connection: connections){
            if(ds.findPar(connection[0]) != ds.findPar(connection[1])){
                ds.unionBySize(connection[0], connection[1]);
            }
            else{
                noOfWires++;
            }
        }
        for(int i=0; i<n; i++){
            if(ds.parent[i] == i){
                noOfWiresNeeded++;
            }
        }

        return noOfWiresNeeded > noOfWires ? -1 : noOfWiresNeeded;
    }
}
