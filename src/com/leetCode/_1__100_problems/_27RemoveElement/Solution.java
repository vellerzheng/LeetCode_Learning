package com.leetCode._1__100_problems._27RemoveElement;

public class Solution {

    public int removeElement(int[] nums, int val) {

        if(nums ==null || nums.length == 0)
            return 0;
        int length =0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val ){
                nums[length] = nums[i];
                length++;
            }

        }
        return length;
    }

    /**
     * 我把所有不需要删除的元素都移动到数组前面，把需要删除的元素都移动到数组后面，
     * 然后返回的值不就相当于新数组的长度吗？由于那些已经删除的元素的位置都在这个新数组的长度之外，
     * 所以根本不会被访问到，这样不就变相实现了删除功能吗？了解了这些，思路就应该大致形成了。根据提示声明两个指针，
     * 分别从数组开头和末尾扫描，末尾的指针主要作用是跳过那些已经是被删除了的元素（即它们的值等于给定的val值），
     * 到第一个没被“删除”的元素的位置后停止。然后，开头位置的指针开始移动，遇到应该被删除的元素就将其和末尾指针
     * 所对应的元素进行交换，再将末尾指针向前移动一位（一定要在现在移动，否则之后可能出现重复计算已删除元素的数量，
     * 使得最后的结果变小），最后再将开头位置指针向前移动一位即可。
     * @param nums
     * @param val
     * @return
     */
    public int removeElementl(int[] nums, int val) {
        int result=0;
        int i=0;
        int j = nums.length-1;
        while(j>=0&&i<=j){
            if(nums[j]==val){
                j--;
                result++;
                continue;
            }
            if(nums[i]==val){
                nums[i] = nums[j];
                nums[j] = val;
                j--;
                result++;
            }
            i++;
        }
        return nums.length-result;
    }

    public static void  main(String[] args){

        int nums[] = {3,2,2,3};

        int len =new Solution().removeElementl(nums,2);
        for(int i=0;i<len;i++)
            System.out.println("result: "+nums[i]);

    }
}
