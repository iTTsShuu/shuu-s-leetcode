/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] boxes = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '0' - 1;
                    cols[j][num]++;
                    rows[i][num]++;
                    boxes[i / 3][j / 3][num]++;
                    if (cols[j][num] > 1 || rows[i][num] > 1 || boxes[i / 3][j / 3][num] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end
