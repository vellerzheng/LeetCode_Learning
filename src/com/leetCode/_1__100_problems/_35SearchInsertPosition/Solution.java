package com.leetCode._1__100_problems._35SearchInsertPosition;

/**
 * @Author: vellerzheng
 * @Description:
 * @Date:Created in 21:44 2018/5/22
 * @Modify By:
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;

        while(i<=j){
            int mid = (i+j)/2;
            if(target > nums[mid]){
                i=mid+1;
            }else if(target < nums[mid]){
                j=mid -1;
            }else {
                return mid;
            }
        }
        return i;
    }
    public static void main(String[] args) {


        int[] nums = {1,2,8,9,10,12};
        int target = 5;

        System.out.println("result: " + new Solution().searchInsert(nums,target));

    }
}
