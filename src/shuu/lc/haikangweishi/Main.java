package haikangweishi;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    /* Write Code Here */
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] ans = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            ans[i / n][i % n] = original[i];
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] res;

        int original_size = 0;
        original_size = in.nextInt();
        int[] original = new int[original_size];
        for (int original_i = 0; original_i < original_size; original_i++) {
            original[original_i] = in.nextInt();
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }

        int m;
        m = Integer.parseInt(in.nextLine().trim());

        int n;
        n = Integer.parseInt(in.nextLine().trim());

        res = new Solution().construct2DArray(original, m, n);
        int res_rowLength = res.length;
        int res_colLength = res[0].length;
        for (int res_i = 0; res_i < res_rowLength; res_i++) {
            for (int res_j = 0; res_j < res_colLength; res_j++) {
                System.out.println(String.valueOf(res[res_i][res_j]) + " ");
            }
        }

    }
}
