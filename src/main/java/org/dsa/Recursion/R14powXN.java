package org.dsa.Recursion;

public class R14powXN {
    public static void main(String[] args) {
        myPow(2, 10);
    }
    public static double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if(n<0) nn= nn*-1;
        while(nn>0){
            if(nn%2 == 1){
                ans = ans * x;
                nn = nn-1;
            }
            if(nn%2 == 0){
                x = x*x;
                nn = nn/2;
            }
        }
        if(n <0) ans = (double)1.0/(double)ans;
        return ans;
    }
}
