/*
 * @lc app=leetcode.cn id=832 lang=java
 *
 * [832] 翻转图像
 */

// @lc code=start

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        Integer[][] imageIntegers = image;

        return null;
    }
}

// @lc code=end
/**
 * 832.翻转图像
 */
class test832 {
    public static void main(String[] args) {
        int[] image = new int[] { 1, 2, 3 };
        Integer[] imaIntegers = image;

        List<Integer> asList = Arrays.asList(imaIntegers);
        Collections.reverse(asList);
        asList.forEach(s -> {
            System.out.println(s);
        });
    }
}