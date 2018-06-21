package com.leetCode._1__100_problems._39CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: vellerzheng
 * @Description:思路分析
    给一个数组candidates，数组中元素都不相同，给一个target值，
    candidates中的元素可以无限次使用，找到所有能够加合成target的集合。

    将candidates排序，从小到大开始递归寻找。递归每次都从candidates的第一个元素开始，
每次target剪去一个candidates的元素值，然后继续进行递归。为了防止重复，设置一个start值，
表示start之前的candidates的元素就不需要遍历了，因为在前面已经递归过了。
 * @Date:Created in 20:17 2018/5/28
 * @Modify By:
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res =new ArrayList<>();
        if(candidates == null) return res;
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        combinatinHelper(res,new ArrayList<>(),candidates,target,0);
        return res;
    }

    void combinatinHelper(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int start){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i= start; i<nums.length;i++){
            if(nums[i] > target) break;
            if(i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            combinatinHelper(res,list,nums,target-nums[i],i);
            list.remove(list.size()-1);
        }
    }


    public static void main(String[] args) {


        int [] candidate = {2,3,5};
        int target = 8;

        System.out.println("result: " + new Solution().combinationSum(candidate,target));

    }
}
