package leniu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        // 二分查找
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    static List<String> UpLowtransform(List<String> list) {
        List<String> tmpList = new ArrayList<>();
        for (int i = 0; i < list.size(); ++i) {
            String cur = list.get(i);
            if (cur.charAt(0) - 'Z' > 0) { // 小写
                tmpList.add(cur.toUpperCase());
            } else {
                tmpList.add(cur.toLowerCase());
            }
        }
        return tmpList;
    }

    private static String choicesWV(int n) {
        // 分别计算时间 耗时
        double tw = n;
        double tv = 10 + n / 10;
        return tw > tv ? "v" : "w";
    }

    public static void main(String[] args) {
        // 2
        Scanner in = new Scanner(System.in);
        // 这里输入怎么保证个数
        List<String> list = new ArrayList<>();
        String nextLine = in.nextLine();

        do {
            list.add(nextLine);
            nextLine = in.nextLine();
        } while (!"".equals(nextLine));
        // 转换
        list = UpLowtransform(list);
        for (String string : list) {
            System.out.println(string);
        }

        // 3
        // Scanner in = new Scanner(System.in);
        // int n = in.nextInt();
        // System.out.println(choicesWV(n));

    }

}
