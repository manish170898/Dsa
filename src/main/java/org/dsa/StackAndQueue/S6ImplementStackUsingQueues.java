package org.dsa.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class S6ImplementStackUsingQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public S6ImplementStackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1= q2;
        q2 = temp;
    }

    public int pop() {
        return !q1.isEmpty() ? q1.poll() : -1;
    }

    public int top() {
        return !q1.isEmpty() ? q1.peek() : -1;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
