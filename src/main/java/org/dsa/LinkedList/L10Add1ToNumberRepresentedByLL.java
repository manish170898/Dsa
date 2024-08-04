package org.dsa.LinkedList;

public class L10Add1ToNumberRepresentedByLL {
//    https://www.naukri.com/code360/problems/add-one-to-a-number-represented-as-linked-list_920557?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
    public static Node addOne(Node head) {
        // Write your code here.

        int carry = recAddition(head);
        if(carry == 1){
            Node newHead = new Node(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    public static int recAddition(Node node){
        if(node == null){
            return 1;
        }
        int carry = recAddition(node.next);
        node.data += carry;
        if(node.data >= 10){
            node.data = node.data %10;
            return 1;
        }
        else{
            return 0;
        }
    }
}
