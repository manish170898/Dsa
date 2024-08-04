package org.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

public class R12GenerateParentheses {
//    https://leetcode.com/problems/generate-parentheses/description/

    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        int ope = n;
        int clo = n;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generatePara(ope, clo, list, sb);
        return list;
    }

    public static void generatePara(int ope, int clo, List<String> list, StringBuilder sb){
        if(ope == 0 && clo == 0){
            list.add(sb.toString());
            return;
        }
        if(clo == ope){
            sb.append("(");
            generatePara(ope-1, clo, list, sb);
            sb.delete(sb.length()-1, sb.length());
        }
        if(ope == 0){
            sb.append(")");
            generatePara(ope, clo-1, list, sb);
            sb.delete(sb.length()-1, sb.length());
        }
        else if(clo > ope){
            sb.append("(");
            generatePara(ope-1, clo, list, sb);
            sb.delete(sb.length()-1, sb.length());
            sb.append(")");
            generatePara(ope, clo-1, list, sb);
            sb.delete(sb.length()-1, sb.length());
        }
    }
}
