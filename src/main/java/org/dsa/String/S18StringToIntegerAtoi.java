package org.dsa.String;

public class S18StringToIntegerAtoi {
//    https://leetcode.com/problems/string-to-integer-atoi/description/
    public int myAtoi(String s) {
        int ans=0;
        int i=0;
        int sign=1;
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
//        Handling Empty String:
        if(s.length()==0){
            return 0;
        }
//        Skipping Leading Whitespaces:
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
//          Handling Optional Sign:
        if(i<s.length() && (s.charAt(i)=='-'|| s.charAt(i)=='+')){
            if(s.charAt(i)=='-'){
                sign=-1;
            }
            i++;
        }
//        Converting Digits:
//        while (i < s.length() && s.charAt(i) - '0' <= 9 && s.charAt(i) - '0' >= 0): The while loop iterates through characters as long as they are valid digits (between '0' and '9') and the index i is within the string bounds.
//        int digit = s.charAt(i) - '0': Converts the current character (assumed to be a digit) to its corresponding integer value by subtracting the ASCII value of '0'.
        while(i<s.length() && s.charAt(i)-'0'<=9 && s.charAt(i)-'0'>=0){
            int digit = s.charAt(i)-'0';
//            Overflow Handling:
//            if (ans > max / 10 || (ans == max / 10 && digit > max % 10)): This condition checks for potential overflow situations for positive numbers.
//            It compares the current accumulated value (ans) with the maximum integer value (max) divided by 10 (considering the next digit) and the remainder (max % 10).
//            If ans is already greater than the maximum divided by 10, or if ans is equal to the maximum divided by 10 and the current digit (digit) is greater than the remainder, it signifies overflow.
            if(ans>max/10 || (ans==max/10 && digit>max%10)){
                return (sign == 1) ? max : min;
            }
            ans=ans*10+digit;
            i++;
        }
        return ans*sign;
    }
}
