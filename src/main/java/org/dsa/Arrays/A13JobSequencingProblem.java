package org.dsa.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


 //// DIY YOU UNDERSTOOD THE SOLUTION

//Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1.
// Maximize the total profit if only one job can be scheduled at a time.
//
//        Examples:
//
//        Input: Four Jobs with following deadlines and profits
//
//        JobID  Deadline  Profit
//
//        a           4          20
//        b           1          10
//        c           1          40
//        d          1          30
//
//        Output: Following is maximum profit sequence of jobs: c, a
//
//        Input:  Five Jobs with following deadlines and profits
//
//        JobID   Deadline  Profit
//
//        a            2          100
//        b            1          19
//        c            2          27
//        d            1          25
//        e            3          15
//
//        Output: Following is maximum profit sequence of jobs: c, a, e

public class A13JobSequencingProblem {
    char id;
    int deadline, profit;

    // Constructors
    public A13JobSequencingProblem() {}

    public A13JobSequencingProblem(char id, int deadline, int profit)
    {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    // Function to schedule the jobs take 2
    // arguments arraylist and no of jobs to schedule
    void printJobScheduling(ArrayList<A13JobSequencingProblem> arr, int t)
    {
        // Length of array
        int n = arr.size();

        // Sort all jobs according to
        // decreasing order of profit
        Collections.sort(arr,
                (a, b) -> b.profit - a.profit);

        // To keep track of free time slots
        boolean result[] = new boolean[t];

        // To store result (Sequence of jobs)
        char job[] = new char[t];

        // Iterate through all given jobs
        for (int i = 0; i < n; i++)
        {
            // Find a free slot for this job
            // (Note that we start from the
            // last possible slot)
            for (int j
                 = Math.min(t - 1, arr.get(i).deadline - 1);
                 j >= 0; j--) {

                // Free slot found
                if (!result[j])
                {
                    result[j] = true;
                    job[j] = arr.get(i).id;
                    break;
                }
            }
        }

        // Print the sequence
        for (char jb : job)
        {
            System.out.print(jb + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer N = Integer.parseInt(st.nextToken());

    }
}


// Non Overlapping cASE