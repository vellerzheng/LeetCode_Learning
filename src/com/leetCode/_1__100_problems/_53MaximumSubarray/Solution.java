package com.leetCode._1__100_problems._53MaximumSubarray;

/**
 * @Author: vellerzheng
 * @Description:
 * @Date:Created in 10:33 2018/6/25
 * @Modify By:
 */
public class Solution {

    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0)
                sum = A[i];
            else
                sum += A[i];
            if (sum > max)
                max = sum;
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum = sum < 0? nums[i] : (sum + nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] strs = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println("result: " + new Solution().maxSubArray1(strs));
    }

}
