package org.dsa.String;

import java.util.*;

public class S9Enicurcular {
    public static List<String> doesCircleExist(List<String> commands) {
        List<String> result = new ArrayList<>();
        for(int j = 0; j < commands.size() ;j++) {
            String temp = commands.get(j);
            String newPath = temp+temp+temp+temp;
            char[] paths = newPath.toCharArray();

            int X = 0;
            int Y = 0;
            int direction = 0;
            for(int i = 0; i < paths.length; i++) {
                char moves = paths[i];
                if(moves == 'R')
                    direction = (direction + 1) %4;
                else if(moves == 'L')
                    direction = (4 + direction -1) % 4;
                else {
                    if(direction == 0)
                        Y++;
                    else if(direction == 1)
                        X++;
                    else if(direction == 2)
                        Y--;
                    else
                        X--;
                }
            }

            if(X == 0 && Y == 0  || (direction!=0)) {
                result.add("YES");
            } else {
                result.add("NO");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> instr = new ArrayList<>();
        instr.add("GGGGR");
        instr.add("RGL");
//        instr.add("RLGG");
//        instr.add("LRGRG");
        List<String> ans = doesCircleExist(instr);
        for(String s: ans)
            System.out.println(s);
    }
}
