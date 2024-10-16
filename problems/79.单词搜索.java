import java.lang.invoke.ClassSpecializer.Factory;
import java.util.PrimitiveIterator.OfDouble;

import javax.swing.border.Border;

/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length, m=board[0].length;
        char[] words=word.toCharArray();
        boolean[][] done=new boolean[n][m];
        boolean ans=false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = dfs(board, words, i, j, 0, done);
                if(ans) return true;
            }
        }

        return false;
    }
    public boolean dfs(char[][] board,  char[] words, int i, int j, int k,boolean[][] done){
        //剪枝部分判断
        if( i>=board.length || i<0 || j>=board[0].length || j<0 || done[i][j] || board[i][j]!=words[k])
        return false;
        if(k == words.length-1)return true;
        
        //四个方向的遍历

            //标记已经遍历过的位置
            done[i][j]=true;
            boolean ans=dfs(board, words, i+1, j, k+1, done) || dfs(board, words, i, j+1, k+1, done) ||
                        dfs(board, words, i-1, j, k+1, done) || dfs(board, words, i, j-1, k+1, done)  ;
            done[i][j]=false;

        return ans;
    }
}
// @lc code=end

