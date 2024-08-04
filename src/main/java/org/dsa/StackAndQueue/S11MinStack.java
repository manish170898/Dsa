package org.dsa.StackAndQueue;

import java.util.Stack;

class PairA{
    int val;
    int min;
    public PairA(int val, int min){
        this.val = val;
        this.min = min;
    }
}

public class S11MinStack {
    Stack<PairA> s;

    public S11MinStack() {
        s = new Stack<>();
    }

    public void push(int val) {
        if(s.isEmpty()){
            s.push(new PairA(val,val));
        }
        else{
            PairA pair = s.peek();
            if(pair.min <= val){
                s.push(new PairA(val,pair.min));
            }
            else{
                s.push(new PairA(val,val));
            }
        }
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek().val;
    }

    public int getMin() {
        return s.peek().min;
    }
}
