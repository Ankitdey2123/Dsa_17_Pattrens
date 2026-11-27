class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
               int n = items.length;

        int minPrice = Integer.MAX_VALUE;
        for (int[] it : items) {
            minPrice = Math.min(minPrice, it[1]);
        }

        // value of the first copy of each item: itself + free copies it unlocks
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    cnt++;
                }
            }
            val[i] = 1 + cnt;
        }

        // 0/1 knapsack: dp[b] = max value with total cost at most b
        int[] dp = new int[budget + 1];
        for (int i = 0; i < n; i++) {
            int p = items[i][1];
            for (int b = budget; b >= p; b--) {
                dp[b] = Math.max(dp[b], dp[b - p] + val[i]);
            }
        }

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[b] + (budget - b) / minPrice);
        }
        return ans;
    }
}