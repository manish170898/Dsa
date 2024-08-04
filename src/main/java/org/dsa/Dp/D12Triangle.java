package org.dsa.Dp;

import java.util.ArrayList;
import java.util.List;

public class D12Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
//        https://leetcode.com/problems/triangle/description/
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>(triangle.get(0)));
        int ans = Integer.MAX_VALUE;
        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        for(int i=1; i<triangle.size(); i++){
            dp.add(new ArrayList<>());
            List<Integer> row = triangle.get(i);
            for(int j=0; j<row.size(); j++){
                if(j==0){
                    dp.get(i).add(dp.get(i-1).get(j) + row.get(j));
                }
                else if(j == row.size()-1){
                    dp.get(i).add(dp.get(i-1).get(j-1) + row.get(j));
                }
                else{
                    int optionA = dp.get(i-1).get(j-1) + row.get(j);
                    int optionB = dp.get(i-1).get(j) + row.get(j);
                    dp.get(i).add(Math.min(optionA, optionB));
                }
                if(i == triangle.size()-1){
                    ans = Math.min(ans, dp.get(i).get(j));
                }
            }
        }
        return ans;
    }
}
