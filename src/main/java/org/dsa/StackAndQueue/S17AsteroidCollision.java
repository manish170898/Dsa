package org.dsa.StackAndQueue;

import java.util.Stack;

public class S17AsteroidCollision {
//    https://leetcode.com/problems/asteroid-collision/description/

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<asteroids.length; i++){
            if(st.isEmpty() || asteroids[i] >= 0 || st.peek() < 0){
                st.push(asteroids[i]);
            }
            else {
                if(Math.abs(asteroids[i]) == st.peek()) st.pop();
                else if(Math.abs(asteroids[i]) > st.peek()){
                    i--;
                    st.pop();
                }
            }
        }
        int[] res = new int[st.size()];
        int i = st.size() - 1;
        while(!st.isEmpty()) {
            res[i--] = st.pop();
        }
        return res;
    }
}
