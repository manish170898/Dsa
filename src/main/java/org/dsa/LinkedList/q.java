package org.dsa.LinkedList;

@FunctionalInterface
interface Operation {
    public double calculate(double num1, double num2);
}

class A {
    A(){
        System.out.println("here");
    }
    A(int b){
        this();
        System.out.println(b);
    }
}


public class q {
    int a;
    static{
    }
    public static void main(String[] args) {

        A a = new A(5);

//        int[] arr = {1,2,2,2,3,3,3,6,9,4,5};
//        int k=0;

//        Operation adder = (num1, num2) -> num1 + num2;
//        double result = adder.calculate(1,2);
//        System.out.println(result);
//
//        System.out.println(exc());

    }

//    private static int exc() {
//        try{
//            throw new Exception();
//        }
//        catch(Exception e){
//            System.out.println("cathc");
//            return 0;
//        }
//        finally {
//            System.out.println("finally");
//            return 1;
//        }
//    }
//    public static <E> void deisplayDetails( E[] inputarray){
//        for(E e: inputarray){
//            System.out.println(e + " ");
//        }
//    }
}

//class MyClass<T> {
//    T val1;
//    T val2;
//
//    public MyClass(T val1, T val2) {
//        this.val1 = val1;
//        this.val2 = val2;
//    }
//}

/*

-> Min Matrix Problem
-> Champagne Tower
-> Sum of 2 numers = target
-> [4 5 5 6 6 ]
    [1 2 1 1 2]

->
https://leetcode.com/problems/maximum-profit-in-job-scheduling/
Process/Thread


*/

