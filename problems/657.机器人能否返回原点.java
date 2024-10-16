/*
 * @lc app=leetcode.cn id=657 lang=java
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        int[] xy={0,0};
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'R':
                    xy[0]++;
                    break;
                case 'L':
                    xy[0]--;
                    break;
                case 'U':
                    xy[1]++;
                    break;
                case 'D':
                    xy[1]--;
                    break;
            }
        }
        boolean ans=false;
        if (xy[0]==0&&xy[1]==0) {
            ans=true;
        }
        return ans;
    }
}
// @lc code=end

