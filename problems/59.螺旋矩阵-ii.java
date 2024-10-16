/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        if(n==0){
            return matrix;
        }
        int[][] dirs=new int[][]{
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };// 左下右上
        int col=0,row=0;
        int change=1;
        int maxN=n*n;
        int dirI=0;
        while (change<=maxN) {
            matrix[row][col]=change;
            change++;
            int dirRow=row+dirs[dirI][0],dirCol=col+dirs[dirI][1];
            if(dirCol==n||dirCol<0||dirRow==n||dirRow<0||matrix[dirRow][dirCol]!=0){
                //方向改变
                dirI=(dirI+1)%4;
            }
            row+=dirs[dirI][0];
            col+=dirs[dirI][1];
        }
        return matrix;
    }
    
}
// @lc code=end

