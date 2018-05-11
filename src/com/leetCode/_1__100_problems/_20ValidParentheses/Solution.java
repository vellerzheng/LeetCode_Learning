package com.leetCode._1__100_problems._20ValidParentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();

        char[] chars =s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '{' || aChar == '[') {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (aChar == ')' && stack.peek() == '(' ||
                            aChar == '}' && stack.peek() == '{' ||
                            aChar == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }

                }

            }
        }
        return stack.isEmpty();
    }



    public static void  main(String[] args){

        String s = "([()])";
        System.out.println("result: "+new Solution().isValid(s));

    }

}
