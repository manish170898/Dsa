package org.dsa.String;

public class S7ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
//        https://leetcode.com/problems/reverse-prefix-of-word/description/?envType=daily-question&envId=2024-05-01
        StringBuilder sb = new StringBuilder();
        boolean fOcc = false;

        for(int i=0; i<word.length(); i++){
            sb.append(word.charAt(i));
            if(word.charAt(i) == ch && !fOcc){
                sb.reverse();
                fOcc = true;
            }
        }
        return sb.toString();
    }
}
