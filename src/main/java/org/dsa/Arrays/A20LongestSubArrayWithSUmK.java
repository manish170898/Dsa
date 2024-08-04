package org.dsa.Arrays;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// optimal solution for  positives and negatives
public class A20LongestSubArrayWithSUmK {
    public static void main(String[] args) throws IOException {
    int[] arr = {10, 2, -2, -20, 10};
    int T=5;
    int S =-10;
    Map<Integer,Integer> map = new HashMap<>();
    int sum =0;
    map.put(sum,0);
    int ans = -1;
    for(int i=0; i<T; i++)
        {
            sum= sum+arr[i];
            if(sum-S >= 0){
                if(map.containsKey(sum-S)){
                    int k1 = map.get(sum-S);
                    if(i- k1 > ans){
                        ans = i-k1;
                    }
                }
            }
            map.put(sum,i+1);
        }
    }

//    two pointer approach
//is optimal

}
