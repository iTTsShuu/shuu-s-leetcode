/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && isEage(board, i, j)) {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(char[][] board, int i, int j) {
        if (!inArea(board, i, j)) {
            return;
        }
        if (board[i][j] == 'X') {
            return;
        }
        if (board[i][j] == 'T') {
            return;
        }
        // 标记访问过的O区域
        if (board[i][j] == 'O') {
            board[i][j] = 'T';
            // 深度访问各个方向
            // return dfs(board, i - 1, j) &&
            // dfs(board, i + 1, j) &&
            // dfs(board, i, j + 1) &&
            // dfs(board, i, j - 1);
            // if (dfs(board, i + 1, j) &&
            // dfs(board, i - 1, j) &&
            // dfs(board, i, j + 1) &&
            // dfs(board, i, j - 1)) {
            // // 回溯进行修改
            // board[i][j] = 'X';
            // }

            // // 此后没有修改的T复原
            // if (board[i][j] == 'T') {
            // board[i][j] = 'O';
            // }
            dfs(board, i - 1, j);
            dfs(board, i + 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }

    boolean inArea(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

    boolean isEage(char[][] board, int i, int j) {
        return i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1;
    }

    public void printArrays(char[][] Tarray) {
        for (int i = 0; i < Tarray.length; i++) {
            for (int j = 0; j < Tarray[0].length; j++) {
                System.out.print(Tarray[i][j] + ", ");
            }
            System.out.println(" ");
        }
    }
}
// @lc code=end

/**
 * 130.被围绕的区域
 */
class rerasdassd {
    public static void main(String[] args) {
        char[][] cva = new char[][] {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        };
        // char[][] cva2 = new char[][] {
        // { 'O', 'O', 'O' },
        // { 'O', 'O', 'O' },
        // { 'O', 'O', 'O' },
        // { 'O', 'O', 'O' }
        // };
        mySolution solution = new mySolution();
        solution.solve(cva);
        solution.printArrays(cva);
    }

}