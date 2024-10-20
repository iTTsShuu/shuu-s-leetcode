import java.util.ArrayList;
import java.util.List;

public class odd {
    // 储存可能性
    List<Integer> memo = new ArrayList<>();

    /**
     * 取所有nums中选k个数的可能组合的和 加入memo
     * 
     * @param nums
     * @param used
     * @param sum
     * @param cnt
     */
    public void getdfs(int[] nums, int k, int cnt, int last, int sum) {
        if (cnt == k) {
            memo.add(sum);
            return;
        }
        for (int i = last; i < nums.length; i++) {
            getdfs(nums, k, cnt + 1, i + 1, sum + nums[i]);
        }
    }

    List<List<Integer>> combinations = new ArrayList<>();

    // shuu: last用来开始选择nums中数位置的下标
    /**
     * last用来开始选择nums中数位置的下标
     * 这个方法用来求nums中选择k个数的所有的组合 结果在combinations中
     * 
     * @param nums
     * @param k
     * @param cnt
     * @param last
     * @param curCom
     */
    public void getdfs(int[] nums, int k, int cnt, int last, List<Integer> curCom) {
        if (cnt == k) {
            combinations.add(new ArrayList<>(curCom));
            return;
        }
        for (int i = last; i < nums.length; i++) {
            curCom.add(nums[i]);
            // last串i+1表示下次从i+1位置的数开始选
            getdfs(nums, k, cnt + 1, i + 1, curCom);
            curCom.remove(cnt);
        }
    }

    void printMemoSize() {
        System.out.println("数量：" + memo.size());
        // for (Integer integer : memo) {
        // System.out.printf("%4s", integer);
        // }
        // System.out.println("");
    }

    void printCombinations() {

        System.out.println("组合数量：" + combinations.size());
        for (List<Integer> comb : combinations) {
            System.out.printf("[");
            for (Integer x : comb) {
                System.out.printf("%3d", x);
            }
            System.out.println("]");
        }
    }

    void getOddOrEvenCnt() {
        int evenCnt = 0;
        int oddCnt = 0;
        for (Integer x : memo) {
            if (x % 2 == 0) {
                evenCnt++;
            } else {
                oddCnt++;
            }
        }
        System.out.printf("奇数占比：%.2f %% \n", ((oddCnt * 1.0) / (memo.size() * 1.0)) * 100);
        System.out.printf("偶数占比：%.2f %% \n", ((evenCnt * 1.0) / (memo.size() * 1.0)) * 100);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        odd odd = new odd();
        // odd.getdfs(nums, 5, 0, 0, new ArrayList<>());
        // odd.printCombinations();
        odd.getdfs(nums, 5, 0, 0, 0);
        // odd.printMemoSize();
        odd.getOddOrEvenCnt();
    }
}
