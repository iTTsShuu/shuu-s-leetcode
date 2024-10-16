import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int i=0;
        while(i<n){
            int somOfgas=0;
            int somOfCost=0;
            int count=0;
            while(count<n){
                int j=(i+count)%n;
                somOfgas+=gas[j];
                somOfCost+=cost[j];
                if(somOfCost>somOfgas){
                    break;
                }
                else{
                    count++;
                }
            }
            if(count==n){
                return i;   
            }
            else{
                i=i+count+1;
            }
        }
        return -1;
    }
}
// @lc code=end
// class tesssssss{
//     public static void main(String[] args) {
//         mySolution solution=new mySolution();
//         int[] gas={2,3,4};
//         int[] cost ={3,4,3};
//         System.out.println(solution.canCompleteCircuit(gas, cost));
//     }
// }
