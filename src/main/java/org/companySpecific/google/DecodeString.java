package org.companySpecific.google;

/*
    https://leetcode.com/discuss/interview-experience/5499901/Google-L3-ChancesExperience
    Round 2 : Given an n ary tree we have to decode the string.
    Example :
    A
    / \
    B(Hi) C
    / \
    D(I) E(am)
    Every leaf is linked to some decoded string which means every path from root to leaf has a decoded value.
    "AB" -> "Hi"
    "ACD" -> "I"
    "ACE" -> "am"
    Input will be a string that we need to decode if that is not possible return "Invalid".
    Example "ABABACDACE" --> "HiHiIam"
    "ABCBACE" --> "Invalid"
 */

import java.util.*;
class Node {
    Map<Character, Node> children;
    String decodedString;

    public Node() {
        children = new HashMap<>();
        decodedString = null;
    }
    public Node(String string) {
        children = new HashMap<>();
        decodedString = string;
    }

}
public class DecodeString {
    public static void main(String[] args) {
        Node root = new Node();
        root.children.put('A', new Node());
        Node aNode = root.children.get('A');
        aNode.children.put('B', new Node("Hi"));
        aNode.children.put('C', new Node());
        aNode.children.get('C').children.put('D', new Node("I"));
        aNode.children.get('C').children.put('E', new Node("am"));

        String encodedString = "ABCBACE";

        String decodeString = decode(root, encodedString);
        System.out.println(decodeString);

    }

    private static String decode(Node root, String encodedString) {
        int n = encodedString.length();
        StringBuilder decodedString = new StringBuilder();
        for(int i=0; i<n; ++i) {
            Node curr = root;
            while(i<n && curr.children.containsKey(encodedString.charAt(i))) {
                curr = curr.children.get(encodedString.charAt(i));
                if(curr.decodedString != null) {
                    decodedString.append(curr.decodedString);
                    break;
                }
                ++i;
            }
            if(curr.decodedString == null) {
                return "Invalid";
            }
        }
        return decodedString.toString();
    }
}
