package com.leetCode._1__100_problems._14LongestCommonPrefix;

import java.util.Arrays;

public class Solution {

    public String longestCommonPrefix(String[] strs) {

        StringBuilder result = new StringBuilder();
        if (strs != null && strs.length > 0) {
            //Sort the array first, and then you can simply compare the first and last elements in the sorted array
            Arrays.sort(strs);
            char[] begChar = strs[0].toCharArray();
            char[] endChar = strs[strs.length - 1].toCharArray();

            for (int i = 0; i < begChar.length; i++) {
                if (endChar.length > i && begChar[i] == endChar[i]) {
                    result.append(begChar[i]);
                } else {
                    return result.toString();
                }
            }
        }
        return result.toString();
    }


    /**
     * 利用了字符串的indexOf方法，通过返回位置是不是0判断是不是公共前缀，如果返回值不是0，
     * 就将这个临时公共前缀删除最后一个字符，在进行尝试，直到返回值为0为止
     * @param strs
     * @return
     */
    public String longestCommonPrefixl(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
        return pre;
    }


    public static void  main(String[] args){

        String[] source={"flower","flow","flight"};
        System.out.println("result: "+new Solution().longestCommonPrefixl(source));

    }

}
