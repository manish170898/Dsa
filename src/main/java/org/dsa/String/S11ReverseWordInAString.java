package org.dsa.String;

public class S11ReverseWordInAString {
    public static void main(String[] args) {
        String s = "a good   example";
        reverseWords(s);
    }
    public static String reverseWords(String s) {
        String str = s.trim();
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) == ' '){
                sb.reverse();
                ans.append(sb.toString());
                ans.append(" ");
                sb = new StringBuilder();
                while(str.charAt(i) == ' '){
                    i--;
                }
                i++;
            }
            else sb.append(str.charAt(i));
        }
        sb.reverse();
        ans.append(sb.toString());

        return ans.toString();
    }
}
