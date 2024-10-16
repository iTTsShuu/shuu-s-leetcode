/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    // 复制有额外的矩阵空间使用
    public void oldgameOfLife(int[][] board) {
        // 复制一份棋盘不更新，只做更新参照
        int m = board.length;
        int n = board[0].length;
        int[][] tmpboard = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmpboard[i][j] = board[i][j];
            }
        }
        int[] poss = new int[] { -1, 0, 1 };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    // 死细胞情况
                    int count = 0;
                    for (int k = 0; k < 3; k++) {
                        for (int k2 = 0; k2 < 3; k2++) {
                            int x = poss[k];
                            int y = poss[k2];
                            if (i + x >= 0 && i + x < m && j + y >= 0 && j + y < n) {
                                if (tmpboard[i + x][j + y] == 1) {
                                    count++;
                                }
                            }
                        }
                    }
                    if (count == 3) {
                        board[i][j] = 1;
                    }
                } else {
                    // 活细胞情况
                    int count = 0;
                    for (int k = 0; k < 3; k++) {
                        for (int k2 = 0; k2 < 3; k2++) {
                            int x = poss[k];
                            int y = poss[k2];
                            if (x == y && x == 0) {
                                continue;
                            }
                            if (i + x >= 0 && i + x < m && j + y >= 0 && j + y < n) {
                                if (tmpboard[i + x][j + y] == 1) {
                                    count++;
                                }
                            }
                        }
                    }
                    if (count < 2 || count > 3) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    /**
     * 1表示活细胞
     * 0表示死细胞
     * 2表示即将变为活细胞的死细胞
     * -1表示即将变为死细胞的活细胞
     * 
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int[] poss = new int[] { -1, 0, 1 };
        // 遍历原矩阵，直接在源矩阵上修改
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;
                for (int k = 0; k < 3; k++) {
                    for (int k2 = 0; k2 < 3; k2++) {
                        int x = poss[k];
                        int y = poss[k2];
                        if (x == y && x == 0) {
                            continue;
                        }
                        if (i + x >= 0 && j + y >= 0 && i + x < board.length && j + y < board[0].length) {
                            if (board[i + x][j + y] == 1 || board[i + x][j + y] == -1) {
                                count++;
                            }
                        }
                    }
                }
                if (board[i][j] == 1) {
                    // 原本为活细胞
                    if (count < 2 || count > 3) {
                        board[i][j] = -1;
                    }
                } else {
                    // 原本为死细胞
                    if (count == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        // 进行更新
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
// @lc code=end

class ttetet {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        solution.gameOfLife(board);
    }
}