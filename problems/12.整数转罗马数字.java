/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start

import java.util.Scanner;

class Solution {
    public String intToRoman(int num) {
        int weishu = 0;
        int tempnum = num;
        // 计算数字的位数
        StringBuffer sb = new StringBuffer();
        while (tempnum != 0) {
            int lastnum = tempnum % 10;
            tempnum = tempnum / 10;
            weishu++;
            String chars = getcharbyint(lastnum, weishu);
            sb.insert(0, chars);
        }
        return sb.toString();

    }

    private String getcharbyint(int num, int weishu) {
        switch (weishu) {
            case 4:
                String s = new String();
                for (int i = 0; i < num; i++) {
                    s += "M";
                }
                return s;
            case 3:
                switch (num) {
                    case 9:
                        return "CM";
                    case 5:
                        return "D";
                    case 4:
                        return "CD";
                    default:
                        String ss = new String();
                        if (num < 4) {
                            for (int i = 0; i < num; i++) {
                                ss += "C";
                            }
                        } else {
                            ss += "D";
                            for (int i = 0; i < num - 5; i++) {
                                ss += "C";
                            }
                        }
                        return ss;
                }
            case 2:
                switch (num) {
                    case 9:
                        return "XC";
                    case 5:
                        return "L";
                    case 4:
                        return "XL";
                    default:
                        String ss = new String();
                        if (num < 4) {
                            for (int i = 0; i < num; i++) {
                                ss += "X";
                            }
                        } else {
                            ss += "L";
                            for (int i = 0; i < num - 5; i++) {
                                ss += "X";
                            }
                        }
                        return ss;
                }
            case 1:
                switch (num) {
                    case 9:
                        return "IX";
                    case 5:
                        return "V";
                    case 4:
                        return "IV";
                    default:
                        String ss = new String();
                        if (num < 4) {
                            for (int i = 0; i < num; i++) {
                                ss += "I";
                            }
                        } else {
                            ss += "V";
                            for (int i = 0; i < num - 5; i++) {
                                ss += "I";
                            }
                        }
                        return ss;
                }
            default:
                return null;
        }
    }
}
// @lc code=end

class tetetete {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入：");
            int num = scanner.nextInt();
            System.out.println(solution.intToRoman(num));
        }
    }
}
