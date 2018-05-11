package com.leetCode._1__100_problems._17LetterCombinationsOfaPhoneNumber;



import java.util.*;

public class Solution {



    public List<String> letterCombinationsl(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i = 0; i < digits.length(); i++){
            int x = Integer.parseInt(digits.charAt(i)+"");
            while(ans.peek().length() == i){
                String t = ans.poll();
                for(char s : mapping[x - 2].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }


    public static void  main(String[] args){

        String str ="2334";
        System.out.println("result: "+new Solution().letterCombinationsl(str));

    }

}

