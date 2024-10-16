/*
 * @lc app=leetcode.cn id=649 lang=java
 *
 * [649] Dota2 参议院
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String predictPartyVictory(String senate) {
        int size = senate.length();
        int RNum = 0, DNum = 0;
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            char ch = senate.charAt(i);
            deque.add(ch);
            if (ch == 'R') {
                RNum++;
            } else {
                DNum++;
            }
        }
        int banedR = 0, banedD = 0;
        while (RNum != 0 && DNum != 0) {
            Character curR = deque.remove();
            if (curR == 'R') {
                if (banedR == 0) {
                    banedD++;
                    deque.add(curR);
                } else {
                    banedR--;
                    continue;
                }
                DNum--;
            } else {
                if (banedD == 0) {
                    banedR++;
                    deque.add(curR);
                } else {
                    banedD--;
                    continue;
                }
                RNum--;
            }
        }
        if (RNum == 0 && DNum != 0) {
            return "Dire";
        }
        if (RNum != 0 && DNum == 0) {
            return "Radiant";
        }
        return "";
    }
}
// @lc code=end
