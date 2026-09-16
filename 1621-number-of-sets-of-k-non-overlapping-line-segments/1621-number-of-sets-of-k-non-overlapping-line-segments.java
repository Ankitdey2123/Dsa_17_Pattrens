class Solution {
    public int numberOfSets(int n, int k) {
         final long MOD = 1_000_000_007L;

        // dp[i][j] = number of ways to draw j segments
        // using points 0...i, where point i is available.
        long[][] dp = new long[n][k + 1];

        // prefix[i][j] = dp[0][j] + dp[1][j] + ... + dp[i][j]
        long[][] prefix = new long[n][k + 1];

        // 0 segments -> exactly 1 way
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            prefix[i][0] = i + 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {

                // Don't use point i as the endpoint of a new segment.
                dp[i][j] = dp[i - 1][j];

                // Add a segment whose right endpoint is i.
                //
                // Its left endpoint can be p = 0 ... i-1.
                // If p = 0, there is 1 way to have j-1 previous segments.
                // If p > 0, the previous segments can end at or before p.
                dp[i][j] += prefix[i - 1][j - 1];

                dp[i][j] %= MOD;

                // Update prefix sum.
                prefix[i][j] = prefix[i - 1][j] + dp[i][j];
                prefix[i][j] %= MOD;
            }
        }

        return (int) dp[n - 1][k];
    }
}