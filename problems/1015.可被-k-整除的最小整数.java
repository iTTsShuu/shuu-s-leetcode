import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1015 lang=java
 *
 * [1015] 可被 K 整除的最小整�?
 */

// @lc code=start
class Solution {
    public int smallestRepunitDivByK(int k) {
        int res=1%k,len=1;
        Set<Integer> m=new HashSet<>();
        m.add(res);
        while(res!=0){
            res=(res*10+1)%k;
            len++;
            if(m.contains(res)){
                return -1;
            }
            m.add(res);
        }
        return len;
    }
}
// @lc code=end

