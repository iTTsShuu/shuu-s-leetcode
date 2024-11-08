import java.lang.reflect.Array;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;

import java.util.ListResourceBundle;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int i, j, k;
        for (i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                    if (j >= k)
                        break;
                    while (nums[j] == nums[j - 1]) {
                        j++;
                        if (j >= k)
                            break;
                    }
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                    if (j >= k)
                        break;
                    while (nums[k] == nums[k + 1]) {
                        k--;
                        if (j >= k)
                            break;
                    }
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> tempIntegers = new ArrayList<>();
                    tempIntegers.add(nums[i]);
                    tempIntegers.add(nums[j]);
                    tempIntegers.add(nums[k]);
                    ans.add(tempIntegers);
                    j++;
                    if (j >= k)
                        break;
                    while (nums[j] == nums[j - 1]) {
                        j++;
                        if (j >= k)
                            break;
                    }
                    k--;
                    if (j >= k)
                        break;
                    while (nums[k] == nums[k + 1]) {
                        k--;
                        if (j >= k)
                            break;
                    }
                    continue;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList = new ArrayList();
        // -nums[k]=nums[i]+sums[k]
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {
            int target = nums[k];
            addAns(-target, ansList, k, nums);
        }
        return ansList;
    }

    void addAns(int target, List<List<Integer>> ansList, int k, int[] nums) {

        int left = 0, right = nums.length - 1;

        while (left < right) {

            int sum = nums[left] + nums[right];
            if (left == k) {
                left++;
            } else if (right == k) {
                right--;
            } else if (sum == target) {
                List<Integer> list = new ArrayList();
                list.add(target);
                list.add(nums[left]);
                list.add(nums[right]);
                ansList.add(list);
                break;
            } else if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }

        }
    }
}
// @lc code=end

class test {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        mySolution solution = new mySolution();
        System.out.println(solution.threeSum(nums));

    }
}
