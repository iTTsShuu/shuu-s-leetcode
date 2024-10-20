import java.util.ArrayList;
import java.util.List;

public class odd {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> memo = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += nums[i];
            memo.add(sum);
        }
    }
}
