import java.lang.reflect.Array;

/*
 * @lc app=leetcode.cn id=1996 lang=java
 *
 * [1996] 游戏中弱角色的数量
 */

// @lc code=start
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(i,j)->i[0]!=j[0]?j[0]-i[0]:i[1]-j[1]);
        int maxA=0;
        int ans=0;
        for(int[] temp:properties){
            if(temp[1]>=maxA){
                maxA=temp[1];
            }
            else{
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

