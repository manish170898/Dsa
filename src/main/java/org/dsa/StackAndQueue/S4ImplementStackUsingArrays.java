package org.dsa.StackAndQueue;

public class S4ImplementStackUsingArrays {
    int top;
    int[] arr = new int[1000];
    S4ImplementStackUsingArrays()
    {
        top = -1;
    }
    //Function to push an integer into the stack.
    void push(int a)
    {
        // Your code here
        arr[++top] = a;
    }
    //Function to remove an item from top of the stack.
    int pop()
    {
        // Your code here
        if(top==-1){
            return -1;
        }
        return arr[top--];
    }
}
