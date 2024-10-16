/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Stack;

import javax.xml.stream.events.Characters;

class Solution {
    public String decodeString(String s) {
        char[] sc = s.toCharArray();
        int n = sc.length;
        Deque<Integer> times = new ArrayDeque();
        Deque<String> chs = new ArrayDeque();
        StringBuilder ansSb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = sc[i];
            // 数字
            if (Character.isDigit(ch)) {
                int digit = 0;
                // 多位数处理
                while (Character.isDigit(ch)) {
                    digit *= 10;
                    digit += ch - '0';
                    i++;
                    ch = sc[i];
                }
                i--;
                times.push(digit);
            } else if (Character.isLetter(ch) || ch == '[') {
                chs.push(String.valueOf(ch));
            } else {
                // ']'情况 ，将代构建字符加入栈
                Deque<String> tmpQueue = new ArrayDeque();
                while (!"[".equals(chs.peek())) {
                    tmpQueue.push(chs.pop());
                }
                chs.pop();
                // 栈弹出 反向构建字符串
                StringBuilder tmpSb = new StringBuilder();
                while (!tmpQueue.isEmpty()) {
                    tmpSb.append(tmpQueue.pop());
                }
                // 获取次数
                int curTimes = times.pop();
                String add = tmpSb.toString();
                // 完成构建
                for (int j = 1; j < curTimes; j++) {
                    tmpSb.append(add);
                }
                chs.push(tmpSb.toString());
            }
        }
        // 拼接答案
        while (!chs.isEmpty()) {
            String pop = chs.pop();
            ansSb.insert(0, pop);
        }
        return ansSb.toString();
    }
}

// @lc code=end
class test394 {
    public static void main(String[] args) {
        Solution394 solution = new Solution394();
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        System.out.println(solution.decodeString(s));
    }
}