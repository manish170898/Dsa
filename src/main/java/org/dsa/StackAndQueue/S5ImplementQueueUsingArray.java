package org.dsa.StackAndQueue;

public class S5ImplementQueueUsingArray {
    int front, rear;
    int arr[] = new int[100005];
    int size = 0;
    S5ImplementQueueUsingArray()
    {
        front=0;
        rear=0;
    }

    //Function to push an element x in a queue.
    void push(int x)
    {
        // Your code here
        rear = rear % arr.length;
        arr[rear] = x;
        rear++;
        size++;
    }

    //Function to pop an element from queue and return that element.
    int pop()
    {
        if(size == 0) return -1;
        // Your code here
        front = front%arr.length;
        size--;
        return arr[front++];
    }
}
