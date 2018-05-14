package com.leetCode._1__100_problems._29DivideTwoIntegers;


/**
 * 不能使用乘除和取模，这时可以考虑使用位运算。每次将divisor左移一位，直到超过dividend。为了便于计算，统一将两个数字转换为负数。

 例子中9可以左移3位，即9×2×2×2=72，再左移的话就会超过dividend。这时重新计算dividend = 100 - 72 = 28.

 再次左移，9×2=18，重新计算dividend=28-18=10.

 再次左移，9×1 = 9，重新计算divident = 10-9=1，小于divisor，停止。

 最后结果为2×2×2+2+1=11

 需要注意的情况：2147483647, 1，-2147483648, 1，-2147483648, -2147483648

 divisor为1时，计算耗时，可以单独考虑。divisor<<1就越界时，可以单独考虑。重点考虑越界情况。
 */
public class Solution {

    public  int divide(int dividend, int divisor){
        boolean neg =false;

        if((dividend < 0 && divisor >0) || (dividend > 0 && divisor < 0))
            neg = true;
        if(divisor == 1) return  dividend;
        // 考虑越界 int 最小-2147483648， 最大2147483647
        if(divisor == -1 ) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;

        // 都转换为负数计算
        if(dividend > 0) dividend = -dividend;
        if(divisor > 0) divisor = - divisor;

        //考虑左移越界问题
        if(divisor << 1 >= 0){
            if(dividend <= divisor)
                return neg ? -1:1;
            else
                return 0;
        }

        int res =0, k = dividend;
        while (k<= divisor){
            int tmp = divisor;
            int m = 1 ;

            while (tmp >= k && tmp <<1 <0){
                tmp = tmp <<1;
                m = m<<1;
            }

            k = k-(tmp >>1);
            res = res+(m>>1);
        }
        return neg ? -res:res;
    }

    public static void main(String[] args) {


        int dividend = 256;
        int divisor = -3;

        System.out.println("result: " + new  Solution().divide(dividend,divisor));

    }
}


