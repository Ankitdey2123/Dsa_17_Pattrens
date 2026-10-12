class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
 int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][minProfit + 1];

        dp[0][0] = 1;

        for (int i = 0; i < group.length; i++) {
            int crime = group[i];
            int cprofit = profit[i];

            for (int peo = n; peo >= crime; peo--) {
                for (int minp = minProfit; minp >= 0; minp--) {
                    int nextProfit = Math.min(minProfit, minp + cprofit);

                    dp[peo][nextProfit] =
                        (dp[peo][nextProfit]
                        + dp[peo - crime][minp]) % MOD;
                }
            }
        }

        int ans = 0;

        for (int peo = 0; peo <= n; peo++) {
            ans = (ans + dp[peo][minProfit]) % MOD;
        }

        return ans;
    }
}