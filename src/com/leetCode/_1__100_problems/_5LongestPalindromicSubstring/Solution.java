package com.leetCode._1__100_problems._5LongestPalindromicSubstring;

public class Solution {

    public String longestPalindrome(String s) {
        String result = "";

        if(s.length() <= 1000) {
            int len = s.length();
            String tmp = "";

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len - i; j++) {
                    tmp = s.substring(i, len - j);

                    if (tmp.equals(reverseString(tmp)) && tmp.length() > result.length()) {
                        result = tmp;
                    }
                }
            }
        }

        return result;
    }

    public String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public String longestPalindromel(String s) {
        char[] chArray = s.toCharArray();
        int len = chArray.length * 2 + 3;
        char[] nch = new char[len];
        nch[0] = '@'; // 3. 添加特殊字符，防止访问越界
        nch[len-1] = '$';
        for (int i=1; i<len-1; i++) {
            if ((i & 1) != 0) {
                nch[i] = '#'; // 1. 在字符串中添加特殊字符，将两种情况统一解决
            } else {
                nch[i] = chArray[(i>>1) - 1];
            }
        }
        int[] p = new int[len];

        int maxid = 0, center = 0, longest = 1, longestCenter = 0;
        for (int i=1; i<len-1; i++) {
            // 2. 算法的精华
            if (maxid > i) {
                p[i] = Math.min(p[2*center-i], maxid-i);
            } else {
                p[i] = 1;
            }
            while (nch[i-p[i]]==nch[i+p[i]]) {
                p[i]++;
            }
            if (p[i]+i > maxid) {
                maxid = p[i]+i;
                center = i;
            }
            if (longest < p[i]) {
                longest = p[i];
                longestCenter = center;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=longestCenter+1-longest; i<longestCenter+longest; i++) {
            if (nch[i] != '#')
                sb.append(nch[i]);
        }
        return sb.toString();

    }

    /**
     * 以某个元素为中心，分别计算偶数长度的回文最大长度和奇数长度的回文最大长度。
     * 时间复杂度O(n^2)，空间O（1）
     * @param s
     * @return
     */
    public String longestPalindromell(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    //不完善方法，数组容易越界
    String longestPalindromelll(String s) {
       int len = s.length();
        if(len <= 1)return s;
        int start=0, maxLen = 0;
        for(int i = 1; i < len; i++)
        {
            //寻找以i-1,i为中点偶数长度的回文
            int low = i-1, high = i;
            while(low >= 0 && high < len && s.charAt(low) == s.charAt(high))
            {
                low--;
                high++;
            }
            if(high - low - 1 > maxLen)
            {
                maxLen = high - low -1;
                start = low + 1;
            }

            //寻找以i为中心的奇数长度的回文
            low = i- 1; high = i + 1;
            while(low >= 0 && high < len && s.charAt(low) == s.charAt(high))
            {
                low--;
                high++;
            }
            if(high - low - 1 > maxLen)
            {
                maxLen = high - low -1;
                start = low + 1;
            }
        }
        return s.substring(start, maxLen);
    }

    public static void  main(String[] arg){

        String str = "caac";
        System.out.println("result: "+new Solution().longestPalindromelll(str));

    }

}
