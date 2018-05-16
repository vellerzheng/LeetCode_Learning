package com.leetCode._1__100_problems._34SearchForARange;

import java.util.ArrayList;
import java.util.List;


// 这种二分法适合已经排序的数组
public class Solution {
    public int[] searchRange(int[] nums, int target) {

        int l=0, n = nums.length, r = n-1;
        // 在L<R的情况下，因为每次二分后的mid必小于R大于或等于L，
        // 由L = mid + 1;R = mid;可知：每经过一次循环，L与R的距离必定-1。
        // 最终的结果一定是L == R，那么检查nums[L] == target是否成立即可。
        while (l< r){
            int mid =(l+r)/2;
            if(nums[mid] <target)
                l = mid+1;
            else
                r=mid;
        }
        if(nums.length < 1 ||nums[l] != target ){
            return new int[]{-1, -1};
        }
        int left = l, right =l;
        while (left >0 && nums[left] == nums[left -1]) left--;
        while (right< n-1 && nums[right] == nums[right+1]) right++;
        return  new int[]{left,right};
    }

    public static void main(String[] args) {


        int[] nums = {};
        int target = 8;

        System.out.println("result: " + new  Solution().searchRange(nums,target));

    }
}
