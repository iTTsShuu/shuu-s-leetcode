/*
 * @lc app=leetcode.cn id=3242 lang=java
 *
 * [3242] 设计相邻元素求和服务
 */

// @lc code=start
class NeighborSum {
    int[][] grid;
    int n;
    int[][] adjacentSums;
    int[][] diagonalSums;
    int[][] indexMap;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.adjacentSums = new int[n][n];
        this.diagonalSums = new int[n][n];
        this.indexMap = new int[n * n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur = grid[i][j];
                indexMap[cur][0] = i;
                indexMap[cur][1] = j;
            }
        }
        sumAdjacent();
        sumDiagonal();
    }

    public int adjacentSum(int value) {
        // 哈希表找到行列下标
        int row = indexMap[value][0];
        int col = indexMap[value][1];
        return adjacentSums[row][col];
    }

    public int diagonalSum(int value) {
        // 哈希表找到行列下标
        int row = indexMap[value][0];
        int col = indexMap[value][1];
        return diagonalSums[row][col];
    }

    private void sumAdjacent() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    adjacentSums[i][j] = grid[i + 1][j] + grid[i][j + 1];
                } else if (i == n - 1 && j == n - 1) {
                    adjacentSums[i][j] = grid[i - 1][j] + grid[i][j - 1];
                } else if (i == 0 && j == n - 1) {
                    adjacentSums[i][j] = grid[i + 1][j] + grid[i][j - 1];
                } else if (i == n - 1 && j == 0) {
                    adjacentSums[i][j] = grid[i - 1][j] + grid[i][j + 1];
                } else if (i == 0) {
                    adjacentSums[i][j] = grid[i + 1][j] + grid[i][j + 1] + grid[i][j - 1];
                } else if (i == n - 1) {
                    adjacentSums[i][j] = grid[i - 1][j] + grid[i][j + 1] + grid[i][j - 1];
                } else if (j == 0) {
                    adjacentSums[i][j] = grid[i + 1][j] + grid[i - 1][j] + grid[i][j + 1];
                } else if (j == n - 1) {
                    adjacentSums[i][j] = grid[i - 1][j] + grid[i + 1][j] + grid[i][j - 1];
                } else {
                    adjacentSums[i][j] = grid[i - 1][j] + grid[i + 1][j] + grid[i][j - 1] + grid[i][j + 1];
                }
            }
        }
    }

    private void sumDiagonal() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    diagonalSums[i][j] = grid[i + 1][j + 1];
                } else if (i == n - 1 && j == n - 1) {
                    diagonalSums[i][j] = grid[i - 1][j - 1];
                } else if (i == 0 && j == n - 1) {
                    diagonalSums[i][j] = grid[i + 1][j - 1];
                } else if (i == n - 1 && j == 0) {
                    diagonalSums[i][j] = grid[i - 1][j + 1];
                } else if (i == 0) {
                    diagonalSums[i][j] = grid[i + 1][j - 1] + grid[i + 1][j + 1];
                } else if (i == n - 1) {
                    diagonalSums[i][j] = grid[i - 1][j - 1] + grid[i - 1][j + 1];
                } else if (j == 0) {
                    diagonalSums[i][j] = grid[i + 1][j + 1] + grid[i - 1][j + 1];
                } else if (j == n - 1) {
                    diagonalSums[i][j] = grid[i + 1][j - 1] + grid[i - 1][j - 1];
                } else {
                    diagonalSums[i][j] = grid[i - 1][j - 1] + grid[i + 1][j + 1] + grid[i + 1][j - 1]
                            + grid[i - 1][j + 1];
                }
            }
        }
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
// @lc code=end
class test3242 {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                { 1, 2, 0, 3 },
                { 4, 7, 15, 6 },
                { 8, 9, 10, 11 },
                { 12, 13, 14, 5 }
        };
        NeighborSum ns = new NeighborSum(grid);
        System.out.println(ns.diagonalSum(9));
    }
}