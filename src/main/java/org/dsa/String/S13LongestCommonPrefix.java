package org.dsa.String;

public class S13LongestCommonPrefix {
//    https://leetcode.com/problems/longest-common-prefix/description/
    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        longestCommonPrefix(strs);
    }
    public static String longestCommonPrefix(String[] strs) {
        int j=0;
        int i=0;
        StringBuilder sb = new StringBuilder();
        boolean breakk = false;
        while(true){
            if(strs[0].length()-1 < j) break;
            char tbmatch = strs[0].charAt(j);
            for(i=0; i< strs.length; i++){
                String s = strs[i];
                if(s.length()-1<j){
                    breakk = true;
                    break;
                }
                if(s.charAt(j) != tbmatch){
                    breakk=true;
                    break;
                }
            }
            if(breakk) break;
            sb.append(tbmatch);
            j++;
        }
        return sb.toString();
    }
}
