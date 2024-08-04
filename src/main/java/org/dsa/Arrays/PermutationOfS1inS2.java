package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PermutationOfS1inS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 =st.nextToken();
        st = new StringTokenizer(br.readLine());
        String s2 = st.nextToken();
        //USING HASHMAP TLE HOGYA RE BABA
//        Map<Character, Integer> m1 =new HashMap<>();
//        for(int i=0 ;i<s1.length(); i++){
//            if(m1.containsKey(s1.charAt(i))){
//                m1.put(s1.charAt(i),m1.get(s1.charAt(i))+1);
//            }
//            m1.put(s1.charAt(i),1);
//        }
//        Map<Character, Integer> m2 =new HashMap<>();
//        for(int i=0; i<s2.length(); i++) {
//            if (m1.containsKey(s2.charAt(i))) {
//                if (m2.containsKey(s2.charAt(i))) {
//                    m2.put(s2.charAt(i), m2.get(s2.charAt(i)) + 1);
//                }
//                m2.put(s2.charAt(i), 1);
//                if (m1.equals(m2)) {
//                    System.out.println("Present");
//                }
//            } else {
//                m2.clear();
//            }
//        }

//        Input: s1 = "ab", s2 = "eidbaooo"
//        Output: true
        //SLIDING WINDOW APPROACH

        int[] map = new int[26];
        for(char c : s1.toCharArray()) map[c - 'a']++;
        int j = 0;
        int i = 0;
        int count_chars = s1.length();
        while(j < s2.length()){
            if(map[s2.charAt(j++) - 'a']-- > 0)
                count_chars--;
            if(count_chars == 0) System.out.println("TRUE");
            if(j - i == s1.length() && map[s2.charAt(i++) - 'a']++ >= 0)
                count_chars++;
        }
        System.out.println("FALSE");
    }
}
