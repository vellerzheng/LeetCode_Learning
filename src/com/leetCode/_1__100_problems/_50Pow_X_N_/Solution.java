package com.leetCode._1__100_problems._50Pow_X_N_;

/**
 * @Author: vellerzheng
 * @Description:
 * @Date:Created in 21:35 2018/6/22
 * @Modify By:
 */
public class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        if(n == -2147483648)
            return myPow(x * x, -(n / 2));
        else
            return (n % 2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }

    public static void main(String[] args) {



        System.out.println("result: " + new Solution().myPow(2,5));
    }
}
