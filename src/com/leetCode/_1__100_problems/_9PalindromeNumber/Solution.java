package com.leetCode._1__100_problems._9PalindromeNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isPalindrome(int x) {
        if( x<0 )
            return  false;
        List<Integer> source =new ArrayList<>();
        List<Integer> now =new ArrayList<>();
        int num =x;
        int tail;
        while (num !=0){
            tail = num % 10;
            num  = num/10;
            source.add(tail);
            now.add(0,tail);
        }

        if(now.equals(source)) {
            return true;
        } else
            return false;

    }

    public static void  main(String[] arg){

        int x= 12321;
        System.out.println("result: "+new Solution().isPalindrome(x));

    }

}
