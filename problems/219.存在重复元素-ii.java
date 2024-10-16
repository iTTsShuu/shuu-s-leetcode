import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i])<=k){
                    return true;
                }
                else{
                    map.put(nums[i], i);
                }
            }
            else{
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
// @lc code=end

