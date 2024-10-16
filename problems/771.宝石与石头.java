/*
 * @lc app=leetcode.cn id=771 lang=java
 *
 * [771] 宝石与石头
 */

// @lc code=start
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int ans=0;
        for (int i = 0; i < jewels.length(); i++) {
            char jewel=jewels.charAt(i);
            for (int j = 0; j < stones.length(); j++) {
                char stone=stones.charAt(j);
                if(stone==jewel){
                    ans++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

