import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sum = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (sum.containsKey(target - nums[i])) {
                return new int[] { sum.get(target - nums[i]), i };
            }
            sum.put(nums[i], i);
        }
        return new int[] { 0 };
    }

}
// @lc code=end

class TestTwoSum {
    public static void main(String[] args) {
        System.out.println("123");
    }
}
