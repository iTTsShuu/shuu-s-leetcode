import javax.sound.midi.MidiChannel;
import javax.swing.text.html.parser.TagElement;

/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int j=nums.length-1;
        int i=0;
        while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid]>target){
                j=mid-1;
            }
            else if(nums[mid]<target){
                i=mid+1;
            }
            else{
                return mid;
            }
        }
        return i;
    }
}
// @lc code=end

