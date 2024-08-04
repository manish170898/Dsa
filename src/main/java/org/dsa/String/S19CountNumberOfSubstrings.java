package org.dsa.String;

public class S19CountNumberOfSubstrings {
    public static void main(String[] args) {
        String S = "ecbaddce";
        int K = 3;
        System.out.println(substrCount(S, K));
    }
    static long substrCount (String S, int K) {
        // your code here
        long atMostK = countSubStr(S, K);
        long atMOstKMinus1 = countSubStr(S, K-1);

        return atMostK - atMOstKMinus1;
    }

    public static long countSubStr(String s, int K){
        int i=0, j=0;
        int[] dict = new int[26];
        int distCount = 0;
        long count = 0;

        while(i < s.length()){
            char ch = s.charAt(i);
            int pos  = ch-'a';
            if(dict[pos] == 0){
                dict[pos]++;
                distCount++;
            }
            else{
                dict[pos]++;
            }
            while(distCount > K){
                char rCh = s.charAt(j);
                int rPos = rCh - 'a';
                if(dict[rPos] == 1){
                    dict[rPos]--;
                    distCount--;
                }
                else{
                    dict[rPos]--;
                }
                j++;
            }
            count += i-j+1;
            i++;
        }
        return count;
    }
}
