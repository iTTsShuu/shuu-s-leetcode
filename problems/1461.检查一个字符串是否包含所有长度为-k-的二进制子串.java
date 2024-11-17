/*
 * @lc app=leetcode.cn id=1461 lang=java
 *
 * [1461] 检查一个字符串是否包含所有长度为 K 的二进制子串
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        // shuu:关键点在于找打数量相等关系
        // 第一想法是 比较s所有不同的的长度为k的子串和 和 长度为k的二进制的所有二进制字符串的和
        int n = s.length();
        int l = 0, r = k;
        // int sumS = 0;
        Set<String> parttens = new HashSet<>();
        while (r <= n) {
            String sub = s.substring(l, r);
            // if (parttens.add(sub)) {
            // sumS += Integer.parseInt(sub, 2);
            // }
            parttens.add(sub);
            l++;
            r++;
        }
        // 长度为k的所有二进制数的和
        // int targetSum = getSumBinary(k);

        // 不需要判断和 只对数量进行判断即可
        return parttens.size() == Math.pow(2, k);
    }

}

// @lc code=end
class test1461 {
    public static void main(String[] args) {
        String s = "110";
        int n = s.length();
        int l = 0, r = 2;
        int sumS = 0;
        while (r <= n) {
            String sub = s.substring(l, r);
            sumS += Integer.parseInt(sub, 2);
            r++;
            l++;
        }
        System.out.println(sumS);
    }
}