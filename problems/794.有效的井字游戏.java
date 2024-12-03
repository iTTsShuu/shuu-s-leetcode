/*
 * @lc app=leetcode.cn id=794 lang=java
 *
 * [794] 有效的井字游戏
 */

// @lc code=start
class Solution {
    public boolean validTicTacToe(String[] board) {
        // 无非八种情况
        // boolean[][] visited = new boolean[3][3];// 标记访问过的位置
        // 大概只用遍历一边
        int cntX = 0, cntO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char ch = board[i].charAt(j);
                if (ch == 'X') {
                    cntX++;
                } else if (ch == 'O') {
                    cntO++;
                }
            }
        }

        boolean XWins = false, OWins = false;// 记录胜利情况

        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)) {
                if (board[i].charAt(0) == 'X') {
                    XWins = true;
                } else {
                    OWins = true;
                }
            }
            if (board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)) {
                if (board[0].charAt(i) == 'X') {
                    XWins = true;
                } else {
                    OWins = true;
                }
            }
        }

        // 多重if判断？？？？
        if (cntO > cntX || cntX - cntO > 1) {
            return false;
        }
        // 有一方胜利的情况
        if (XWins) {
            return cntX - 1 == cntO;
        }
        if (OWins) {
            return cntO == cntX;
        }
        return true;
    }

    // 多余的 想多了
    // // 其实应该深度遍历同时计数和计算输赢
    // int cntX = 0, cntO = 0;
    // boolean XWins = false, OWins = false;
    // boolean[][] visited = new boolean[3][3];// 标记访问过的 位置

    // public boolean validTicTacToe1(String[] board) {
    // // 深度遍历计数
    // for (int i = 0; i < 3; i++) {
    // for (int j = 0; j < 3; j++) {
    // char cur = board[i].charAt(j);
    // if (!visited[i][j] && (cur == 'X' || cur == 'O')) {
    // dfs(board, i, j, cur);
    // }
    // }
    // }
    // // 多重if判断？？？？
    // if (cntO > cntX || cntX - cntO > 1) {
    // return false;
    // }

    // return true;
    // }

    // private void dfs(String[] board, int x, int y, char last) {
    // if (x < 0 || x >= 3 || y < 0 || y >= 3 || board[x].charAt(y) == ' ') {
    // return;
    // }
    // visited[x][y] = true;
    // if (board[x].charAt(y) == 'X') {
    // cntX++;
    // } else if (board[x].charAt(y) == 'O') {
    // cntO++;
    // }
    // }
}
// @lc code=end
