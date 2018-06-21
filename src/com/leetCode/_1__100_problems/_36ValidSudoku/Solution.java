package com.leetCode._1__100_problems._36ValidSudoku;

/**
 * @Author: vellerzheng
 * @Description:
 * @Date:Created in 10:49 2018/5/25
 * @Modify By:
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board ==null)
            return false;
        boolean[][] row = new boolean[9][9]; //行
        boolean[][] column = new boolean[9][9]; //列
        boolean[][] block = new boolean[9][9];

        for(int i= 0; i< 9;i++){
            for(int j= 0;j<9;j++){
                if(board[i][j] =='.'){
                    continue;
                }
                int c= board[i][j] -'1';
                int loc = i/3*3 + j/3;
                if(row[i][c] || column[j][c] || block[loc][c]) {
                        return false;
                }
                row[i][c] = column[j][c]=block[loc][c]=true;
            }
        }
        return true;
    }

    public static void main(String[] args) {


        char[][] input = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};


        System.out.println("result: " + new Solution().isValidSudoku(input));

    }

}
