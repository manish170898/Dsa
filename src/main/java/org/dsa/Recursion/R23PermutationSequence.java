package org.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

public class R23PermutationSequence {
    public String getPermutation(int n, int k) {
        int fact = 1;
        // as we will divide into n-1 pieces so we calculate n-1!
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<n; i++){
            fact = fact * i;
            list.add(i);
        }
        list.add(n);
        String ans = "";
        k = k-1;
        while(true){
            ans += list.get(k/fact);
            list.remove(k/fact);
            if(list.size() == 0){
                break;
            }
            k = k % fact;
            fact = fact/list.size();
        }
        return ans;
    }

}
