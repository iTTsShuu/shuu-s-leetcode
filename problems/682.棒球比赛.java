import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=682 lang=java
 *
 * [682] 棒球比赛
 */

// @lc code=start
class Solution {
    public int calPoints(String[] operations) {
        List<Integer> sam=new ArrayList<Integer>();
        int addpos=0;
        //直接的i加入会在删除后出现List的长度与ops位置不相等的情况
        for (int i = 0; i < operations.length; i++) {
            addpos=sam.size();
            if(operations[i].equals("+")){
                sam.add(sam.get(addpos-1)+sam.get(addpos-2));
            }
            else if(operations[i].equals("D")){
                sam.add(2*sam.get(addpos-1));
            }
            else if(operations[i].equals("C")){
                sam.remove(addpos-1);
            }
            else{
                sam.add(Integer.parseInt(operations[i]));
            }
        }
        int ans=0;
        for (int i : sam) {
            ans+=i;
        }
        return ans;
    }
}
// @lc code=end

