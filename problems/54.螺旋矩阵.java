import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    /*
     * public List<Integer> spiralOrder(int[][] matrix) {
     * int m=matrix.length,n=matrix[0].length;
     * List<Integer> ans=new ArrayList<Integer>();
     * int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
     * int ndir=0;
     * int a=0,b=-1;
     * while(m!=0&&n!=0){
     * if(ndir%2==0){
     * for (int i = 0; i < n; i++) {
     * a+=dir[ndir][0];
     * b+=dir[ndir][1];
     * ans.add(matrix[a][b]);
     * }
     * m--;
     * }
     * else{
     * for (int i = 0; i < m; i++) {
     * a+=dir[ndir][0];
     * b+=dir[ndir][1];
     * ans.add(matrix[a][b]);
     * }
     * n--;
     * }
     * ndir=(ndir+1)%4;
     * }
     * return ans;
     * }
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ansList = new ArrayList<>();
        int[][] dir = new int[][] {
                { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
        };
        int dirIndex = 0;
        int n = matrix.length, m = matrix[0].length;
        int a = 0, b = -1;
        while (m != 0 && n != 0) {
            if (dirIndex % 2 == 0) {
                for (int i = 0; i < m; i++) {
                    a += dir[dirIndex][0];
                    b += dir[dirIndex][1];
                    ansList.add(matrix[a][b]);
                }
                n--;
            } else {
                for (int i = 0; i < n; i++) {
                    a += dir[dirIndex][0];
                    b += dir[dirIndex][1];
                    ansList.add(matrix[a][b]);
                }
                m--;
            }
            dirIndex = (dirIndex + 1) % 4;
        }
        return ansList;
    }
}

// @lc code=end
class Main {
    public static void main(String[] args) {
        mySolution solution = new mySolution();
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        List<Integer> ans = new ArrayList<>(solution.spiralOrder(matrix));
        System.out.println(ans);
    }
}
