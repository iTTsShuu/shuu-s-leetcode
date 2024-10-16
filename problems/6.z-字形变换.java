/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int addArrayLength = (s.length() >> 1) + 1;
        char[][] addArray = new char[numRows][addArrayLength];
        int[][] dir = new int[][] { { 1, 0 }, { -1, 1 } };
        char[] c = s.toCharArray();
        int i = 0;
        int x = 0, y = 0;
        int curDir = 0;
        while (i < c.length) {
            for (int j = 0; j < numRows && i < c.length; j++) {
                addArray[x][y] = c[i];
                i++;
                if (j != numRows - 1) {
                    x = x + dir[curDir][0];
                    y = y + dir[curDir][1];
                } else {
                    i--;
                }
            }
            curDir = (curDir + 1) % 2;
        }
        StringBuffer sb = new StringBuffer();
        for (char[] aa : addArray) {
            for (char a : aa) {
                if (a != '\u0000') {
                    sb.append(a);
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end

class ttttt {
    public static void main(String[] args) {
        mySolution s = new mySolution();
        System.out.println(s.convert("PAYPALISHIRING", 3));
    }
}