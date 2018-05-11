package com.leetCode._1__100_problems._11ContainerWithMostWater;

public class Solution {

    public int  maxArea(int[] height)  {
        if(height.length<2){
            return 0;
        }
        int area=0;
        int maxV=0;
        int start =0;
        int end= height.length-1;
        while (start < end) {
            area = Math.min(height[start],height[end])*(end-start);
            maxV = Math.max(maxV,area);
            if(height[start] < height[end]){
                start++;
            }else if(height[start] > height[end]) {
                end --;
            }else {
                start++;
                end--;
            }

        }
        return  maxV;

    }

    public static void  main(String[] arg){

        int[] x= {1,2,1};
        System.out.println("Max V : "+new Solution().maxArea(x));


    }

}
