/*
 * @lc app=leetcode.cn id=1780 lang=java
 *
 * [1780] 判断一个数字是否可以表示成三的幂的和
 */

// @lc code=start

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Solution {
    public boolean checkPowersOfThree(int n) {

    }
}
// @lc code=end

class test1780 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while (true) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "running");
                    try {
                        Thread.sleep(10000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}