import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> anList=new ArrayList<>();
        backTrack(anList, new ArrayList<>(), n, k, 0,0);
        return anList;
    }
    public void backTrack(List<List<Integer>> ansList,List<Integer> curCom
    , int n, int k , int depth, int last){
        if(depth == k){
            List<Integer> temp=new ArrayList<>();
            temp.addAll(curCom);
            ansList.add(temp);
        }
        else{
            for (int i = last; i < n; i++) {
                curCom.add(i+1); 
                backTrack(ansList, curCom, n, k, depth+1, i+1);
                curCom.remove(depth);
            }
            
        }
    }
}
// @lc code=end

class test{
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.combine(4, 2);

    }
}
