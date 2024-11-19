package huice;

import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<Integer> valueOf(int[] nums, int m) {
        int n = nums.length;
        int curLen = 1, r = 0;
        List<Integer> ans = new LinkedList<>();
        int last = nums[0];
        while (r < n) {
            if (nums[r] == last + 1) {
                last = nums[r];
                curLen++;
            } else {
                last = nums[r];
                curLen = 1;
            }
            if (r >= m - 1) {
                if (curLen >= m) {
                    ans.add(nums[r]);
                } else {
                    ans.add(-1);
                }
            }
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 4, 6, 7, 8, 9 };
        List<Integer> valueOf = valueOf(nums, 3);
        for (Integer x : valueOf) {
            System.out.print(x + " ");
        }
    }
}
