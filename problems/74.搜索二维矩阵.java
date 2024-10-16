/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n= matrix[0].length;
        for (int i = 0; i < m; i++) {
            if( matrix[i][0] <=target && matrix[i][n-1] >= target){
                int posM=i;
                int x=0,y=n-1;
                while(x<=y){
                    int mid = (x+y) >> 1;
                    if (matrix[posM][mid] == target) {
                        return true;
                    }
                    else if (matrix[posM][mid] < target) {
                        x=mid+1;
                    }
                    else{
                        y=mid -1 ;
                    }
                }
                break;
            }
        }
        return false;
    }
}
// @lc code=end

class test {
    public static void main(String[] args) {
        int matrix[][]={
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        mySolution solution=new mySolution();
        System.out.println( solution.searchMatrix(matrix, 3));
    }
}
