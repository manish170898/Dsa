package org.dsa.SlidingWindowTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class Q4FruitIntoBasket {
//    https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1
//    TC -O(2*n)
    public static int totalFruits(int N, int[] fruits) {
        int i=0;
        int j=0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(i < N){
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while(map.size() > 2){
                map.put(fruits[j], map.getOrDefault(fruits[j], 0) - 1);
                if(map.get(fruits[j]) == 0){
                    map.remove(fruits[j]);
                }
                j++;
            }
            ans = Math.max(ans, i-j+1);
            i++;
        }
        return ans;
    }

    public static int totalFruitsOptimal(int N, int[] fruits) {
        int i=0;
        int j=0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(i < N){
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            if(map.size() > 2){
                map.put(fruits[j], map.getOrDefault(fruits[j], 0) - 1);
                if(map.get(fruits[j]) == 0){
                    map.remove(fruits[j]);
                }
                j++;
            }
            if(map.size() <= 2)
                ans = Math.max(ans, i-j+1);
            i++;
        }
        return ans;
    }
}
