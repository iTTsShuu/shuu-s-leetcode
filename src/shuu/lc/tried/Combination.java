package tried;

import java.util.ArrayList;
import java.util.List;

//用来计算组合数
public class Combination {

    /**
     * 求阶乘
     * 
     * @param n
     * @return
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("不接受负数");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * 求组合数
     * 
     * @param n 总数
     * @param m 取出的数
     * @return
     */
    public static long combinations(int n, int m) {
        if (m > n) {
            throw new IllegalArgumentException("错误输入！");
        }
        long nSum = factorial(n);
        long mSum = factorial(m);
        long nMinusMSum = factorial(n - m);
        return nSum / mSum * (nMinusMSum);
    }

    // 储存可能性
    List<Integer> memo = new ArrayList<>();

    /**
     * 组合nums中k个数的所有组合 每个组合求和
     * 
     * @param nums
     * @param k
     * @return 返回可能的组合和
     */
    public List<Integer> getCombinationsSum(int[] nums, int k) {
        if (k > nums.length) {
            throw new IllegalArgumentException("参数错误！！");

        }
        getCombinationsSum(nums, k, 0, 0, 0);
        return memo;
    }

    /**
     * 取所有nums中选k个数的可能组合的和 加入memo
     * 
     * @param nums
     * @param used
     * @param sum
     * @param cnt
     */
    private void getCombinationsSum(int[] nums, int k, int cnt, int last, int sum) {
        if (cnt == k) {
            memo.add(sum);
            return;
        }
        for (int i = last; i < nums.length; i++) {
            getCombinationsSum(nums, k, cnt + 1, i + 1, sum + nums[i]);
        }
    }

    List<List<Integer>> combinations = new ArrayList<>();

    /**
     * 返回数组选择k个的所有组合 列表
     * 
     * @param nums
     * @param k
     * @return
     */
    public List<List<Integer>> getCombinations(int[] nums, int k) {
        combinations = new ArrayList<>();
        if (k > nums.length) {
            throw new IllegalArgumentException("参数错误");
        }
        getCombinations(nums, k, 0, 0, new ArrayList<>());
        return combinations;
    }

    /**
     * 递归的求组合
     * 这个方法用来求nums中选择k个数的所有的组合\
     * 结果在combinations中
     * 
     * @param nums
     * @param k
     * @param cnt
     * @param last   last用来表示开始选择nums中数位置的下标
     * @param curCom
     */
    private void getCombinations(int[] nums, int k, int cnt, int last, List<Integer> curCom) {
        if (cnt == k) {
            combinations.add(new ArrayList<>(curCom));
            return;
        }
        // shuu: last用来开始选择nums中数位置的下标
        for (int i = last; i < nums.length; i++) {
            curCom.add(nums[i]);
            // last串i+1表示下次从i+1位置的数开始选
            getCombinations(nums, k, cnt + 1, i + 1, curCom);
            curCom.remove(cnt);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinations(4, 2));
    }
}
