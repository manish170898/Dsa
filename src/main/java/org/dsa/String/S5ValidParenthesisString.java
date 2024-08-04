package org.dsa.String;

import java.util.Stack;

public class S5ValidParenthesisString {
//    https://leetcode.com/submissions/detail/1225609132/
    public boolean checkValidString(String s) {
        // CAnnot be done using 1 stack so taking 2 stacks
        //we are using index based stack bcs in last step we need to mattch index to see if we have * after a ( bracket or not.
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        //coverting to character array
        char[] arr = s.toCharArray();

        // if we get ( we push into stack 1 .. if we get * we push into stack t .. if ew get a ) we first look into stack 1 for opening otherwise in stack 2 for astrik .. if we dont get anythin that meeans not valid
        for(int i=0 ; i<arr.length; i++){
            if(arr[i] == '('){
                st1.push(i);
            }
            else if(arr[i] == '*'){
                st2.push(i);
            }
            else if(arr[i] == ')'){
                if(!st1.isEmpty() && arr[st1.peek()] == '('){
                    st1.pop();
                }
                else if(!st2.isEmpty() && arr[st2.peek()] == '*'){
                    st2.pop();
                }
                else{
                    return false;
                }
            }
        }

        // now at the end we start popping stack1 with ( and we see if we have any * at index greater than of (. if we dont we retturn false ... if we are successfully able to empty stack1 .. then we have a valid paranthesis.
        while(!st1.isEmpty()){
            Integer index = st1.pop();
            if(!st2.isEmpty() && index< st2.peek()){
                st2.pop();
            }
            else{
                return false;
            }
        }
        return true;
    }
}
