package org.dsa.Arrays;


//Given an integer numRows, return the first numRows of Pascal's triangle.
//
//        In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

import java.util.ArrayList;
import java.util.List;

//Example 1:
//
//        Input: numRows = 5
//        Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//        Example 2:
//
//        Input: numRows = 1
//        Output: [[1]]
public class A6PascalTriangle {


    public static void main(String[] args){
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<Integer>();
        current.add(1);
        result.add(current);

        for(int i=1; i<numRows; i++){
            current = new ArrayList<>();
            List<Integer> temp = result.get(i-1);
            current.add(1);
            for(Integer j = 0 ; j <temp.size() - 1 ; j++){
                current.add(temp.get(j) + temp.get(j+1));
            }
            current.add(1);
            result.add(current);
        }
        return result;
    }


}
