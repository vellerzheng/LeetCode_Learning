package com.leetCode._1__100_problems._30SubstringWithConcatenationOfAllWords;

import java.util.*;

/**
 * 用c++的map就相当容易了，先将L中的字符串在map中建立映射。
 * 然后S从前往后一次以某一个为起始字符判断长度为l_size*word_size的连续字符串
 * 是否都在map中。当然为了防止L中有重复的字符串出现，另设一个counting，
 * 来记录子串的个数，当个数超过word_count[word]的时候，也退出，
 * 遍历S中的下一个字符。
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int l_size = words.length;
        List<Integer> res = new ArrayList<>();
        if(l_size <= 0)
            return res;
        //记录words 字符串中的每一个元素的个数
        Map<String,Integer> word_count = new HashMap<>();
        int word_size = words[0].length();
        for(int i= 0; i< l_size;i++){
            if(word_count.containsKey(words[i])){
                word_count.put(words[i],word_count.get(words[i])+1);
            }else {
                word_count.put(words[i],1);
            }
        }

        // 记录查找过程中的个数
        Map<String ,Integer> counting = new HashMap<>();
        for(int i= 0; i <= s.length()-l_size*word_size;i++){
            counting.clear();
            int j= 0;
            for(;j<l_size;j++){
                String word = s.substring(i + j*word_size, i + j*word_size + word_size);
                if(!word_count.containsKey(word))
                    break;
                if(counting.containsKey(word))
                    counting.put(word,counting.get(word)+1);
                else
                    counting.put(word,1);
                if(counting.get(word) > word_count.get(word))
                    break;
            }
            if(j == l_size)
                res.add(i);
        }
        return res;

    }

    public static void main(String[] args) {


    String s ="barfoothefoobarman";
    String[] strs = {"foo","bar"};

        System.out.println("result: " + new  Solution().findSubstring(s,strs));

    }
}