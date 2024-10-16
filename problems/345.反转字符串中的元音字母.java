/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String reverseVowels(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (isYuanying(ch)) {
                deque.push(ch);
            }
        }
        for (int j = 0; j < s.length(); j++) {
            Character ch = s.charAt(j);
            if (isYuanying(ch)) {
                Character popCh = deque.pop();
                sb.append(popCh);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public boolean isYuanying(Character character) {
        return character == 'a' || character == 'e'
                || character == 'i' || character == 'o' || character == 'u'
                || character == 'A' || character == 'E' || character == 'I'
                || character == 'O' || character == 'U';
    }
}
// @lc code=end
