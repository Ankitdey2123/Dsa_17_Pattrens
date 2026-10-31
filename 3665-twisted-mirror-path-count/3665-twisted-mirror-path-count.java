class Solution {
    public int uniquePaths(int[][] grid) {
                final int MOD = 1_000_000_007;
        int m = grid.length, n = grid[0].length;
        int[][] R = new int[m + 1][n + 1];
        int[][] D = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int tot = (i == 0 && j == 0) ? 1 : (R[i][j] + D[i][j]) % MOD;
                    if (i == m - 1 && j == n - 1) return tot;
                    if (tot == 0) continue;
                    if (j + 1 < n) R[i][j + 1] = (R[i][j + 1] + tot) % MOD;
                    if (i + 1 < m) D[i + 1][j] = (D[i + 1][j] + tot) % MOD;
                } else {
                    // entered moving right -> turned down
                    if (i + 1 < m) D[i + 1][j] = (D[i + 1][j] + R[i][j]) % MOD;
                    // entered moving down -> turned right
                    if (j + 1 < n) R[i][j + 1] = (R[i][j + 1] + D[i][j]) % MOD;
                }
            }
        }
        return 0;
    }
}