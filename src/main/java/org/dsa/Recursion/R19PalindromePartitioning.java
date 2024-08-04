package org.dsa.Recursion;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class R19PalindromePartitioning {
    public static void main(String[] args) {
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();

        rec(0, s, ds, ans);
        return ans;
    }

    public void rec(int index, String s, List<String> ds, List<List<String>> ans){
        if(index >= s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index; i<s.length(); i++){
            if(isPallindrone(s, index, i)){
                ds.add(s.substring(index,i+1));
                rec(i+1, s, ds, ans);
                ds.remove(ds.size()-1);
            }
        }
    }

    public static boolean isPallindrone(String s, int start, int end){
        if(start > end){
            return true;
        }
        else if(s.charAt(start) != s.charAt(end)){
            return false;
        }
        if(!isPallindrone(s,start+1,end-1)) return false;
        return true;
    }
}
