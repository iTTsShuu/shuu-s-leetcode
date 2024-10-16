import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ansList=new ArrayList<>();
        backTrack(ansList, new ArrayList<Integer>(), candidates, target, 0, 0);
        return ansList;
    }
    public void backTrack(List<List<Integer>> ansList,List<Integer> curCombine, 
    int[] candidates, int target, int sum, int lasti){

        if(sum==target){
            List<Integer> tempIntegers=new ArrayList<>();
            tempIntegers.addAll(curCombine);
            ansList.add(tempIntegers);
        }
        else if(sum>target){
            return ;
        }
        else{
            for (int i = lasti; i < candidates.length; i++) {
                sum+=candidates[i];
                curCombine.add(candidates[i]);
                backTrack(ansList, curCombine, candidates, target, sum, i);
                sum-=candidates[i];
                curCombine.remove(curCombine.size()-1);
            }
        }


    }
}
// @lc code=end

class newtest{
    public static void main(String[] args) {
        mySolution solution=new mySolution();
        int[] candidates=new int[]{
            2,3,6,7
        };

        solution.combinationSum(candidates, 7);
    }
}
