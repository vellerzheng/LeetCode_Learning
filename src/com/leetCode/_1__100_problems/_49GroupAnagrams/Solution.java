package com.leetCode._1__100_problems._49GroupAnagrams;

import java.util.*;

/**
 * @Author: vellerzheng
 * @Description:
 * @Date:Created in 20:57 2018/6/22
 * @Modify By:
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs){
        if(strs == null || strs.length == 0)
            return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if(!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("result: " + new Solution().groupAnagrams(strs));
                }

}
