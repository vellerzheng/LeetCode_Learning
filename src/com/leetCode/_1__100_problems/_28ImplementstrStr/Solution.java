package com.leetCode._1__100_problems._28ImplementstrStr;


// 即实现string 的indexOf函数。
public class Solution {

    public int strStr(String haystack, String needle) {
        if( needle.equals(""))
            return 0;
        if ( haystack.equals("")|| haystack.length()<needle.length())
            return -1;

        for(int i =0;i<= haystack.length()-needle.length();i++){
            int j= 0;
            for(; j<needle.length();j++) {
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
            }
            if(j == needle.length())
                return i;
        }
        return  -1;

    }

    public static void main(String[] args) {


        String haystack ="a";
        String needle ="a";


        System.out.println("result: " + new  Solution().strStr("a","a"));

    }
}
