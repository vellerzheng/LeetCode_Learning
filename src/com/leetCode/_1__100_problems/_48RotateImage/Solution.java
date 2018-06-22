package com.leetCode._1__100_problems._48RotateImage;

/**
 * @Author: vellerzheng
 * @Description: 解题思路：
 *                  首先以对角线为轴对称交换，再以中间列（如果有的话）为轴对称交换
 * @Date:Created in 20:04 2018/6/22
 * @Modify By:
 */
public class Solution {
    public void rotate(int[][] matrix) {

        if(matrix.length == 0 || matrix.length == 1){
            return;
        }

        int n = matrix.length;
        for(int i=0 ; i< n ; i++){
            for(int j = i; j < n ; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for(int i = 0; i< n; i++){
            for(int j= 0; j< n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }

    public static void main(String[] args) {

     int[][]   matrix = {
             {1, 2, 3},
             {4, 5, 6},
             {7, 8, 9}};
        new Solution().rotate(matrix);
        for(int i=0;i< matrix.length;i++) {
            for(int j=0;j< matrix.length;j++)
                System.out.print(" " + matrix[i][j]+ ",");
            System.out.println();
        }

    }
}
