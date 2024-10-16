import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2500 lang=java
 *
 * [2500] 删除每行中的最大值
 */

// @lc code=start
class Solution {
    public int deleteGreatestValue(int[][] grid) {
        Integer[][] newgrid=extracted(grid);
        for (Integer[] is : newgrid) {
            Arrays.sort(is,(a,b)->b-a);
        }
        
        int ans=0;
        for (int i = 0; i < newgrid[0].length; i++){
            int max=0;
            for(int j=0;j<newgrid.length;j++){
                max=Math.max(max, newgrid[j][i]);
            }
           ans+=max;
        }
        return ans;
    }
    private Integer[][] extracted(int[][] grid) {
        Integer[][] newgrid=new Integer[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for(int j=0;j<grid[0].length;j++){
                newgrid[i][j]=grid[i][j];
            }
        }
        return newgrid;
    }
}
// @lc code=end

