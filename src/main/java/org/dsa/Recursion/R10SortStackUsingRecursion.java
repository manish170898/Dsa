package org.dsa.Recursion;

import java.util.Stack;

public class R10SortStackUsingRecursion {
    public static void sStack(Stack<Integer> s) {
        if(s.isEmpty()){
            return;
        }
        int popped = s.pop();
        sStack(s);
        sort(s, popped);
    }

    public static void sort(Stack<Integer> s, int element){
        if(s.isEmpty()){
            s.push(element);
            return;
        }
        int pop = s.pop();
        if(element <= pop){
            sort(s, element);
        }
        s.push(pop);
        if(element > pop){
            s.push(element);
        }
    }
}
