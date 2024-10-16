import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> anss = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return anss;
        }
        int left = 0, right = 0;
        int cnt = 0;
        while (cnt < n) {
            left = cnt;
            cnt++;
            while (cnt < n && nums[cnt] == nums[cnt - 1] + 1) {
                cnt++;
            }
            right = cnt - 1;
            if (right != left) {
                anss.add(new String(nums[left] + "->" + nums[right]));
            }
            if (right == left) {
                anss.add(String.valueOf(nums[left]));
            }
        }

        return anss;
    }

    // public List<String> summaryRanges1(int[] nums) {
    // List<String> ans = new ArrayList<>();
    // int n = nums.length;
    // if (n == 0) {
    // return ans;
    // }
    // int j = 0;
    // int i = 0;
    // for (i = 1; i < nums.length; i++) {
    // if (nums[i] != nums[i - 1] + 1) {
    // addRange(j, i, ans, nums);
    // j = i;
    // }
    // }
    // if (i != j) {
    // addRange(j, i, ans, nums);
    // }
    // return ans;
    // }

    // public void addRange(int s, int e, List<String> ans, int[] nums) {
    // if (s == e - 1) {
    // ans.add(String.valueOf(nums[s]));
    // } else {
    // String toadd = nums[s] + "->" + nums[e - 1];
    // ans.add(toadd);
    // }
    // }
}

// @lc code=end
class test228 {
    public static void main(String[] args) {
        Solution228 solution = new Solution228();
        System.out.println(solution.summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 }));
    }
}