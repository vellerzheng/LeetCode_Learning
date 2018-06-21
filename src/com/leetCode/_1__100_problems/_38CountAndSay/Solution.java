package com.leetCode._1__100_problems._38CountAndSay;


/**
 * @Author: vellerzheng
 * @Description:题意是n=1时输出字符串1；n=2时，数上次字符串中的数值个数，因为上次字符串有1个1，所以输出11；
 *              n=3时，由于上次字符是11，有2个1，所以输出21；n=4时，由于上次字符串是21，有1个2和1个1，所以输出1211。
 *              依次类推，写个countAndSay(n)函数返回字符串
 * @Date:Created in 11:40 2018/5/25
 * @Modify By:
 */
class Solution {
    public String countAndSay(int n) {
        String s="1";
        for(int i=1;i<n;++i){
            int count =1;
            String temp = "";
            for(int j=1; j< s.length();++j){
                if(s.charAt(j) == s.charAt(j-1)){
                    ++count;
                }else {
                    temp = temp + (char)(count+'0') +s.charAt(j-1);
                    count =1;
                }
            }
            s = temp + (char)(count +'0') + s.charAt(s.length()-1);
        }
        return s;
    }

    public static void main(String[] args) {



        int target = 6;

        System.out.println("result: " + new Solution().countAndSay(target));

    }
}
