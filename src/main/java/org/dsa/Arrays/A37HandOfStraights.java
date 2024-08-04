package org.dsa.Arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class A37HandOfStraights {
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        isNStraightHand(hand, groupSize);
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int h : hand){
            map.put(h, map.getOrDefault(h,0) + 1);
        }

        int i=0;
        while(!map.isEmpty()){
            int k = 0;
            Integer key = map.firstKey();
            while(k < groupSize){
                if(map.get(key) == null) return false;
                if(map.get(key) == 1){
                    map.remove(key);
                }
                else {
                    map.put(key, map.get(key)-1);
                }
                k++;
                key = key+1;
            }
        }
        return true;
    }
}
