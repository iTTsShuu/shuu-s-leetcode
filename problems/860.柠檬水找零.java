/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] changes={0,0};
        boolean ans=false;
        for (int bill : bills) {
            if(bill==5){
                changes[0]++;
                ans=true;
            }
            else if(bill==10){
                if(changes[0]!=0){
                    changes[0]--;
                    changes[1]++;
                    ans=true;
                }
                else{
                    ans=false;
                    break;
                }
            }
            else if(bill==20){
                if(changes[1]!=0&&changes[0]!=0){
                    changes[0]--;
                    changes[1]--;
                    ans=true;
                }
                else if(changes[0]>=3&&changes[1]==0){
                    changes[0]-=3;
                    ans=true;
                }
                else{
                    ans=false;
                    break;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

