import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1054 lang=java
 *
 * [1054] 距离相等的条形码
 */

// @lc code=start
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer,Integer> count=new HashMap<>();
        for (int b : barcodes) {
            if(!count.containsKey(b)){
                count.put(b, 1);
            }
            else{
                count.put(b, count.get(b)+1);
            }
        }
        PriorityQueue<int[]> pQ=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(Map.Entry<Integer,Integer> entry:count.entrySet()){
            pQ.offer(new int[]{entry.getValue(),entry.getKey()});
        }
        int n=barcodes.length;
        int[] ans=new int[n];
        for (int i = 0; i < n; i++) {
            int[] p=pQ.poll();
            int cx=p[0],x=p[1];
            if(i==0||ans[i-1]!=x){
                ans[i]=x;
                if (cx>1) {
                    pQ.offer(new int[]{cx-1,x});
                }
            }
            else{
                int[] p2=pQ.poll();
                int cy=p2[0],y=p2[1];
                ans[i]=y;
                if (cy>1) {
                   pQ.offer(new int[]{cy-1,y,}); 
                }
                pQ.offer(new int[]{cx,x});
            }
        }
        return ans;
    }
}
// @lc code=end

