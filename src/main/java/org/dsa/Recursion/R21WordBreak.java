package org.dsa.Recursion;

import java.util.List;

public class R21WordBreak {
//    public static void main(String[] args) {
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
////        String s = "leetcode";
//
//        List<String> list = List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
////        List<String> list = List.of("leet","code");
//        System.out.println(wordBreak(s, list));
//    }
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        return recur (0, s, wordDict);
//    }
//
//    public static boolean recur (int index, String s, List<String> wordDict){
//        if(index > s.length()){
//            return false;
//        }
//        for(int i=index; i<s.length(); i++){
//            String subStr = s.substring(index,i+1);
//            if(wordDict.contains(subStr)){
//                if(i+1 == s.length()){
//                    return true;
//                }
//                if(recur(i+1, s, wordDict)) return true;
//            }
//        }
//        return false;
//    }
}
