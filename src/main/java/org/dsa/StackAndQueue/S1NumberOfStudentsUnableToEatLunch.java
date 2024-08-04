package org.dsa.StackAndQueue;

public class S1NumberOfStudentsUnableToEatLunch {

//    https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/?envType=daily-question&envId=2024-04-08

    public static void main(String[] args) {
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};

        System.out.println(countStudents(students, sandwiches));
    }

    // brute force approach would be to make students as queue and sandwiches as stack and perform the operations .... and have a rotate index to see when to stop the loop


    //optimised approach .. count no of ones and zeroes .... and perform operations on sandwiches as a stack .. if anytime found eaters as  0 for any food then rest is the answer
    public static int countStudents(int[] students, int[] sandwiches) {
        int sandZeroEaters = 0;
        int sandOneEaters = 0;

        for(int i=0; i< students.length; i++){
            if(students[i] == 0){
                sandZeroEaters++;
            }
            else if(students[i] == 1){
                sandOneEaters++;
            }
        }

        for(int i=0; i< sandwiches.length; i++){
            if(sandwiches[i] == 0 && sandZeroEaters != 0){
                sandZeroEaters--;
            }
            else if(sandwiches[i] == 1 && sandOneEaters != 0){
                sandOneEaters--;
            }
            else{
                break;
            }
        }

        if(sandZeroEaters == 0 && sandOneEaters == 0){
            return 0;
        }
        else{
            return sandZeroEaters + sandOneEaters;
        }
    }
}
