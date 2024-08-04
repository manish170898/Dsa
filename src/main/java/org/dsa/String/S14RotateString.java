package org.dsa.String;

import java.util.ArrayList;
import java.util.List;

public class S14RotateString {
    public static void main(String[] args) {
        String s = "bbbacddceeb";
        String goal = "ceebbbbacdd";
        rotateString(s, goal);
    }
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        int i=0;
        int j=0;
        List<Integer> possibleStart = new ArrayList<>();
        boolean found = true;

        while(j < goal.length()){
            if(goal.charAt(j) == s.charAt(i)){
                possibleStart.add(j);
            }
            j++;
        }

        for(Integer pS : possibleStart){
            j = pS;
            i = 0;
            found = true;
            while(i < s.length()){
                if(s.charAt(i) != goal.charAt(j)){
                    found = false;
                    break;
                }
                i++;
                j++;
                j = j % goal.length();
            }
            if(found){
                return found;
            }
        }
        return false;
    }
}
