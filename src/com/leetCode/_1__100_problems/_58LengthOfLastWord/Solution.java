package com.leetCode._1__100_problems._58LengthOfLastWord;

/**
 * @Author: vellerzheng
 * @Description:
 * @Date:Created in 11:15 2018/6/29
 * @Modify By:
 */
public class Solution {
    // runtime : 7ms
    public int lengthOfLastWord(String s) {
        String[] splitString = s.split(" ");
        for(int i= splitString.length - 1 ; i>= 0; i-- ){
            if(splitString[i].length() > 0){
                return splitString[i].length();
            }
        }

        return 0;
    }

   // runtime : 6ms
    public int lengthOfLastWord1(String s){
        int length = s.length();
        int count = 0;

        for(int i = length - 1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                if( count == 0)
                    continue;
                else
                    return count;
            }
            count ++;
        }
        return  count;
    }

    public static void main(String[] args) {

        String str = " hello world ";
        System.out.println("result: " + new Solution().lengthOfLastWord1(str));
    }
}
