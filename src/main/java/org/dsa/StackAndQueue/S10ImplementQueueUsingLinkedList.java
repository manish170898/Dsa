package org.dsa.StackAndQueue;

public class S10ImplementQueueUsingLinkedList {
    QueueNode front, rear;

    //Function to push an element into the queue.
    void push(int a)
    {
        // Your code here
        if(front == null){
            front = new QueueNode(a);
            rear = front;
        }
        else{
            front.next = new QueueNode(a);
            front = front.next;
        }
    }

    //Function to pop front element from the queue.
    int pop()
    {
        QueueNode temp = rear;
        // Your code here
        if(temp == null) return -1;
        else if(rear.next != null){
            temp = temp.next;
            int data = rear.data;
            rear = temp;
            return data;
        }
        else{
            int data = rear.data;
            rear = null;
            front = null;
            return data;
        }
    }
}
class QueueNode
{
    int data;
    QueueNode next;
    QueueNode(int a)
    {
        data = a;
        next = null;
    }
}

