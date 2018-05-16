package com.leetCode._1__100_problems._33SearchInRotatedSortedArray;

public class Solution {
    /**
     * 二分法查找
     * 参考：http://www.bubuko.com/infodetail-1930445.html
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums,int target){
        int l= 0, mid=0, r= nums.length-1,  result= -1;
        while (l <= r){
            mid = (l+r)>>1; // 除以二
            if(nums[mid] == target)
                return mid;
            if(nums[l] <= nums[mid]){  // indicate that the nums[m] is in the ascending order
                if(nums[l] <= target && nums[mid]> target){ //target is int [l,m]
                    r = mid - 1;
                }else {  // target is in [m,r]
                    l = mid + 1;
                }
            }else {
                if(nums[mid] < target && nums[r] >= target){ //target is in [m,r]
                    l = mid + 1;
                }else { //target is in [l,m]
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int res=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target)
                res = i;
            else
                continue;
        }
        return res;
    }




    public static void main(String[] args) {


        int[] nums = {5,6,7,0,1,2,4};
        int target = 0;

        System.out.println("result: " + new  Solution().search(nums,target));

    }
}
