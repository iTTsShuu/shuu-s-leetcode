/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        boolean mb=false,nb=false;
        for (int i = 0; i < m; i++) {
            if(matrix[i][0]==0){
                mb=true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if(matrix[0][i]==0){
                nb=true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if(matrix[i][0]==0){
                for (int j = 1; j < n; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if(matrix[0][i]==0){
                for (int j = 1; j < m; j++) {
                    matrix[j][i]=0;
                }
            }
        }
        if(mb){
            for (int i = 0; i < m; i++) {
                matrix[i][0]=0;
            }
        }
        if(nb){
            for (int i = 0; i < n; i++) {
                matrix[0][i]=0;
            }
        }
    }
}
// @lc code=end
// class mainte{
//     public static void main(String[] args) {
//         int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
//         mySolution solution=new mySolution();
//         solution.setZeroes(matrix);
//         for (int[] is : matrix) {
//             for (int is2 : is) {
//                 System.out.print(is2+",");
//             }
//             System.out.println(" ");
//         }
//     }
// }

