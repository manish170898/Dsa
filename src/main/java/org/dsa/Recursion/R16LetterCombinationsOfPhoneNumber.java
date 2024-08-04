package org.dsa.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class R16LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
    public static List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(2,List.of("a","b","c"));
        map.put(3,List.of("d","e","f"));
        map.put(4,List.of("g","h","i"));
        map.put(5,List.of("j","k","l"));
        map.put(6,List.of("m","n","o"));
        map.put(7,List.of("p","q","r","s"));
        map.put(8,List.of("t","u","v"));
        map.put(9,List.of("w","x","y","z"));

        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        recur(0, digits.toCharArray(), map, sb, ans);
        return ans;
    }

    public static void recur(int index, char[] digits,  Map<Integer, List<String>> map, StringBuilder sb, List<String> ans){

        if(index > digits.length-1){
            ans.add(sb.toString());
            return;
        }

        List<String> clist = map.get(Integer.parseInt(String.valueOf(digits[index])));
        for(int i=0; i<clist.size(); i++){
            String letter = clist.get(i);
            sb.append(letter);
            recur(index+1, digits, map, sb, ans);
            sb.delete(sb.length()-1, sb.length());
        }
    }
}
