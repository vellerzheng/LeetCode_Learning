package com.leetCode._1__100_problems._22GenerateParentheses;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.List;

//https://blog.csdn.net/panzw2015/article/details/53026139

public class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate("",n,n);
        return list;

    }

    void generate(String str,int l,int r){

        /**
         *  最后可能出现的情况, 右括号比左括号先用完, 明显不是合法的串,应剔除
         */
        if(l>r)
            return;
        /**
         * 左括号还剩得有, 优先用左括号
         * 该方法将不断深搜, 直到左括号全部用完
         */
        if(l>0){
            String s =str+"(";
            generate(s,l-1,r);
        }
        /**
         * 开始用右括号
         */
        if(r>0){
            String s= str+')';
            generate(s,l,r-1);
        }
        /**
         * 基准情况, 各自都用完, 说明已经形成了一个合法的串,将该串加入list返回
         */
        if( l==0 && r==0){
            list.add(str);
            return;
        }
    }


    public static void  main(String[] args){

        int n=3;
        List<String> list = new Solution().generateParenthesis(n);
        for(String str: list)
            System.out.println("result: "+str);

    }
}
