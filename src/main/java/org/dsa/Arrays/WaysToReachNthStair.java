package org.dsa.Arrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//
//There are n stairs, a person standing at the bottom wants to reach the top.
//        The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.

public class WaysToReachNthStair {
    public static void main(String[] args) throws IOException, InterruptedException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        Integer N = Integer.parseInt(st.nextToken());
//        // FIBONACCI PROBLEM
//        if(N == 0){
//            System.out.println(0);
//        }
//        if(N == 1){
//            System.out.println(1);
//        }
//        int prevOfPrev=1;
//        int prev=1;
//        int current=0;
//        int temp = 0;
//        for(int i=1; i<N; i++){
//            current = prev +prevOfPrev;
//            temp = prev;
//            prev = current;
//            prevOfPrev = temp;
//        }
//        System.out.println(current);

        System.out.println(Arrays.stream(t(Arrays.asList(0,1,2))).collect(Collectors.toList()));

        System.out.println(new String("apples") == new String("apples"));
    }

    public static Boolean[] t(List<Integer> list) {
        boolean hasPos = false;
        boolean hasNeg = false;

        for(int i=0; i< list.size(); i++){
            hasPos = list.get(i) >0;
            hasNeg = list.get(i) <0;
        }

        return new Boolean[] {hasPos, hasNeg};
    }
}
