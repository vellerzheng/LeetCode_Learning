package com.leetCode.alibabaProblems;

import java.util.ArrayList;
import java.util.List;


/**
 * 在阿里巴巴的在线智能客服场景中，会出现服务转交的情况，在转交的时候，我们会进行智能摘要，
 * 但是在摘要之前需要对用户说过的话进行去重的处理，字符串去重的规则是：

 1：相邻的最大重复串需要去掉； 比如说： 【刚才我说了我要退款我要退款我要退款，我都说了我要退款】  去重之后：【刚才我说了我要退款，我都说了我要退款】

 2：重复的字数必须大于1，所以 ：【阿里旺旺】 ，不需要去重

 3：数字不能进行处理，所以：【10000】，不需要去重处理

 现在需要大家编写一段程序进行去重处理，输出去重之后的字符串
 */
public class Solution {

        public String removeDuplicate(String str){
            List<String> data = new ArrayList<String>();

            for (int i = 0; i < str.length(); i++) {
                String s = str.substring(i, i + 1);
                if (!data.contains(s)) {
                    data.add(s);
                }
            }

            String result = "";
            for (String s : data) {
                result += s;
            }

            return  result;

        }

        public String subStringByUnicode(String str){
            String result ="";
            str = str.replaceAll("[\\pP‘’“”]", ",");
            String[] strs = str.split(",");
            for(String strCurr: strs){
                result += removeDuplicate(strCurr)+",";
            }
            return result;
        }

    public static void main(String[] args) {
        String str = "刚才我说了我要退款我要退款我要退款，我都说了我要退款"; // 去重之后：【刚才我说了我要退款，我都说了我要退款】
        String str1 ="阿里旺旺";
        String str2 = "10000";
        String result = new Solution().subStringByUnicode(str);
        System.out.println(result);
    }

}
