package org.dsa.LinkedList;

public class L16DeleteAllOccurrencesOfGivenKeyDLL {
//    https://www.naukri.com/code360/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list_8160461?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
    public static void main(String[] args) {
        NodeDLL node = new NodeDLL(1);
        node.next = new NodeDLL(1);
        node.next.prev = node;

        deleteAllOccurrences(node, 1);
    }

    public static NodeDLL deleteAllOccurrences(NodeDLL head, int k) {
        if(head == null){
            return null;
        }
        NodeDLL mover = head;
        NodeDLL temp = null;
        while(mover != null){
            if(mover.data == k){
                if(mover.next == null){
                    if(mover.prev != null) mover.prev.next = null;
                    else return null;
                    mover.prev = null;
                    mover = mover.next;
                }
                else if(mover == head){
                    head = head.next;
                    head.prev = null;
                    mover = head;
                }
                else{
                    temp = mover.prev;
                    temp.next = mover.next;
                    mover.next.prev = temp;
                    mover.next = null;
                    mover.prev = null;
                    mover = temp.next;
                }
            }
            else {
                mover = mover.next;
            }

        }
        return head;
    }

}

class NodeDLL {
    public int data;
    public NodeDLL next;
    public NodeDLL prev;

    NodeDLL()
    {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }
    NodeDLL(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    NodeDLL(int data, NodeDLL next, NodeDLL prev)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
