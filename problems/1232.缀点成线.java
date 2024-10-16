/*
 * @lc app=leetcode.cn id=1232 lang=java
 *
 * [1232] 缀点成线
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x=coordinates[0][0],y=coordinates[0][1];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i][0]-=x;
            coordinates[i][1]-=y;
        }
        for (int i = 1; i < coordinates.length; i++) {
            if(coordinates[1][0]*coordinates[i][1]!=coordinates[1][1]*coordinates[i][0]){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

class Test{
    public static void main(String[] args) {
        int[][] coor={{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        Solution solution=new Solution();
        System.out.println(solution.checkStraightLine(coor));
    }
}

