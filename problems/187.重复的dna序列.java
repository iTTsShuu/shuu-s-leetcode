/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> times = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            times.put(sub, times.getOrDefault(sub, 0) + 1);
            if (times.get(sub) == 2) {
                ans.add(sub);
            }
        }
        return ans;
    }
}
// @lc code=end
