package shopee;

import java.util.*;

public class Solution {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * 返回这个最短路径的所有时间点，如果没有路径或者最短路径不止一条，那么返回空
     * 
     * @param input_map int整型 二维数组 输入地图，二维数组，0表示不可达（不考虑负数）
     * @return int整型一维数组
     */
    public int[] CheckShortestPathOnlyOne(int[][] input_map) {
        // write code here
        int m = input_map.length;
        int n = input_map[0].length;
        if (input_map[0][0] == 0) {
            return new int[] {};
        }
        // 动态规划 同时及记录路径数量和最小时间
        int[][][] dp = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (input_map[i][j] != 0) {
                    int min = Integer.MAX_VALUE;
                    int pathSum = 0;
                    if (i != 0 && j != 0) {

                        if (dp[i - 1][j - 1][1] != 0) {
                            min = Math.min(min, dp[i - 1][j - 1][1]);
                            pathSum += dp[i - 1][j - 1][0];
                        }
                        if (dp[i - 1][j][1] != 0) {
                            min = Math.min(min, dp[i - 1][j][1]);
                            pathSum += dp[i - 1][j][0];
                        }
                        if (dp[i][j - 1][1] != 0) {
                            min = Math.min(min, dp[i][j - 1][1]);
                            pathSum += dp[i][j - 1][0];
                        }
                        dp[i][j][1] = min;
                        dp[i][j][0] += pathSum;
                    } else if (i == 0 && j == 0) {
                        dp[i][j][1] = input_map[i][j];
                        dp[i][j][0] = 1;
                    } else if (i == 0) {
                        if (dp[i][j - 1][1] != 0) {
                            min = Math.min(min, dp[i][j - 1][1]);
                            pathSum += dp[i][j - 1][0];
                        }
                        dp[i][j][1] = min;
                        dp[i][j][0] += pathSum;
                    } else if (j == 0) {
                        if (dp[i - 1][j][1] != 0) {
                            min = Math.min(min, dp[i - 1][j][1]);
                            pathSum += dp[i - 1][j][0];
                        }
                        dp[i][j][1] = min;
                        dp[i][j][0] += pathSum;
                    }
                }
            }
        }

        return new int[] { dp[m - 1][n - 1][0], dp[m - 1][n - 1][1] };
    }

    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * 输入一个整数数组，判断这个整数数组是否可分
     * 
     * @param input_array int整型 一维数组 整数数组
     * @return bool布尔型
     */
    public boolean checkArray(int[] input_array) {
        // write code here
        int sum = Arrays.stream(input_array).sum();
        // 奇数和一定不可分
        if (sum % 2 != 0) {
            return false;
        }
        // 寻找子序列和为 sum/2
        sum /= 2;

        return dfs(input_array, 0, 0, sum);

    }

    // 递归方法
    boolean dfs(int[] input_array, int last, int curSum, int target) {
        if (curSum == target) {
            return true;
        }
        // 列举所有可能
        for (int i = last; i < input_array.length; i++) {
            if (dfs(input_array, last + 1, curSum + input_array[i], target)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * true 表示类型相同，false表示不相同
     * 
     * @param input_a string字符串
     * @param input_b string字符串
     * @return bool布尔型
     */
    public boolean CheckPatern(String input_a, String input_b) {
        // write code here
        if (input_a.length() != input_b.length()) {
            return false;
        }
        // 加一个 map处理相同数位置出现
        Map<Character, List<Integer>> mapA = new HashMap<>();
        Map<Character, List<Integer>> mapB = new HashMap<>();
        // 双指针？
        char lastA = input_a.charAt(0);
        char lastB = input_b.charAt(0);
        List<Integer> alist = new ArrayList<>();
        alist.add(0);
        mapA.put(lastA, alist);
        List<Integer> blist = new ArrayList<>();
        blist.add(0);
        mapB.put(lastB, blist);
        for (int i = 1; i < input_a.length(); i++) {
            char curA = input_a.charAt(i);
            char curB = input_b.charAt(i);
            List<Integer> curAList = mapA.getOrDefault(curA, new ArrayList<Integer>());
            curAList.add(i);
            mapA.put(curA, curAList);
            List<Integer> curBList = mapB.getOrDefault(curB, new ArrayList<Integer>());
            curBList.add(i);
            mapB.put(curB, curBList);
            if ((curA > lastA && curB <= lastB) ||
                    (curA == lastA && curB != lastB) ||
                    (curA < lastA && curB >= lastB) || !AListSameWithB(mapA.get(curA), mapB.get(curB))) {
                return false;
            }
            lastA = curA;
            lastB = curB;
        }
        return true;
    }

    boolean AListSameWithB(List<Integer> listA, List<Integer> listB) {
        for (int i = 0; i < listA.size(); i++) {
            if (listA.get(i) != listB.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean checkPatern = solution.CheckPatern("abbe", "cdde");
        System.out.println(checkPatern);
    }
}
