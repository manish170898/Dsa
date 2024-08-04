package org.dsa.LinkedList;

public class L13FindLengthOfLoop {
//    https://www.naukri.com/code360/problems/find-length-of-loop_8160455?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

    public static int lengthOfLoop(Node head) {
        // Write your code here
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null){
            return 0;
        }
        int count =1;
        fast = fast.next;
        while(fast != slow){
            fast = fast.next;
            count ++;
        }
        return count;
    }
}
