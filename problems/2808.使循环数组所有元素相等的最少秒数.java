import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.print.attribute.standard.Sides;

/*
 * @lc app=leetcode.cn id=2808 lang=java
 *
 * [2808] 使循环数组所有元素相等的最少秒数
 */

// @lc code=start
class Solution {
    public int minimumSeconds(List<Integer> nums) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int n=nums.size(), res=n;
        //computeIfAbsent方法直接返回后面的坐标数组进行添加
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums.get(i), k->new ArrayList<>()).add(i);
        }
        for(List<Integer> pos: map.values()){
            int tempmax=pos.get(0)+n-pos.get(pos.size()-1);
            //这里是确保环形数组两个元素距离的最大值
            for (int i = 1; i < pos.size(); ++i) {
                tempmax = Math.max(tempmax, pos.get(i) - pos.get(i - 1));
            }
            res=Math.min(res, tempmax/2);
        }
        return res;
    }
}
// @lc code=end
class test{
    public static void main(String[] args) {
        mySolution solution=new mySolution();
        List<Integer> nums=new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(1);
        nums.add(2);
        System.out.println(nums);
        int re =solution.minimumSeconds(nums);
        System.out.println(re);
    }
}
