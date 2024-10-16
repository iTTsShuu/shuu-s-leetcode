import javax.sound.midi.MidiChannel;

/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        int maxlong=Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            maxlong=Math.min(maxlong, strs[i].length());
        }
        int left=0,right=maxlong;
        while(left<right){
            int mid = (right+left+1)/2;
            if(ispre(strs, mid)){
                left=mid;
            }
            else{
                right=mid-1;
            }
        }
        return strs[0].substring(0,left);
    }
    boolean ispre(String[] strs,int length ){
        String str0=strs[0].substring(0,length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < length; j++) {
                if(str0.charAt(j)!=strs[i].charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
class test{
    public static void main(String[] args) {
        mySolution solution =new mySolution();
        String[] strs=new String[]{"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
