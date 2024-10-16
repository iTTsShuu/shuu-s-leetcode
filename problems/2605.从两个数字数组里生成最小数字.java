import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=2605 lang=java
 *
 * [2605] 从两个数字数组里生成最小数字
 */

// @lc code=start
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int min1=10,min2=10,min=10;
        Set<Integer> sameN=new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            min1=Math.min(min1, nums1[i]);
            sameN.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            min2=Math.min(min2, nums2[i]);
            if (sameN.contains(nums2[i])) {
                min=Math.min(min, nums2[i]);
            }
        }
        if(min==10){
            if(min1<min2)return 10*min1+min2;
            else return 10*min2+min1;
        }
        return min;
    }
}
// @lc code=end

