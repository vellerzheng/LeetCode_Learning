package com.leetCode._1__100_problems._26RemoveDuplicatesFromSortedArray;

/**
 * 这道题跟Remove Element类似，也是考察数组的基本操作，属于面试中比较简单的题目。
 * 做法是维护两个指针，一个保留当前有效元素的长度，一个从前往后扫，然后跳过那些重复的元素。
 * 因为数组是有序的，所以重复元素一定相邻，不需要额外记录。时间复杂度是O(n)，空间复杂度O(1)。
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums ==null || nums.length == 0)
            return 0;
        int length =1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] !=nums[i-1]){
                nums[length] =nums[i];
                length++;
            }
        }

        return length;

    }

    public static void  main(String[] args){

       int nums[] = {0,0,1,1,1,2,2,3,3,4};

       int len =new Solution().removeDuplicates(nums);
       for(int i=0;i<len;i++)
        System.out.println("result: "+nums[i]);

    }
}
