package com.leetCode._1__100_problems._13RomanToInteger;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private static Map<Character,Integer> map =new HashMap<Character, Integer>(){
        {
            put('I',1);
            put('V',5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s) {
        int len = s.length();
        int result =0;
        int preVal =0;
        for(int i=len-1; i>=0;i--){
            char key =s.charAt(i);
            int value = map.get(key);
            if(value >= preVal){
                result +=value;
            }else {
                result -=value;
            }
            preVal =value;
        }
        return result;
    }

    public static void  main(String[] arg) {

        String str = "XL";
        System.out.println("Max V : " + new Solution().romanToInt(str));
    }
}
