class Solution {
    public int minimumChanges(String s, int k) {
                int n = s.length();
        final int INF = 1_000_000;

        // precompute divisors for each length
        List<List<Integer>> divs = new ArrayList<>();
        for (int len = 0; len <= n; len++) divs.add(new ArrayList<>());
        for (int len = 2; len <= n; len++) {
            for (int d = 1; d < len; d++) {
                if (len % d == 0) divs.get(len).add(d);
            }
        }

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                if (len == 1) {
                    cost[i][j] = INF;
                    continue;
                }
                int best = INF;
                for (int d : divs.get(len)) {
                    int changes = 0;
                    int groupSize = len / d;
                    for (int g = 0; g < d; g++) {
                        int lo = 0, hi = groupSize - 1;
                        while (lo < hi) {
                            if (s.charAt(i + g + lo * d) != s.charAt(i + g + hi * d)) changes++;
                            lo++;
                            hi--;
                        }
                    }
                    best = Math.min(best, changes);
                }
                cost[i][j] = best;
            }
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int m = j - 1; m < i; m++) {
                    if (dp[m][j - 1] >= INF) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[m][j - 1] + cost[m][i - 1]);
                }
            }
        }
        return dp[n][k];
    }
}