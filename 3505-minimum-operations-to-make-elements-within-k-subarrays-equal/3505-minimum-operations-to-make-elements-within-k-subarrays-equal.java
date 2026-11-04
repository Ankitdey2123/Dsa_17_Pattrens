class Solution {
int m;
    long[] bitCnt, bitSum;

    void update(int idx, long c, long v) {
        for (; idx <= m; idx += idx & -idx) {
            bitCnt[idx] += c;
            bitSum[idx] += v;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        // coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int[] vals = new int[n];
        m = 0;
        for (int v : sorted) {
            if (m == 0 || vals[m - 1] != v) vals[m++] = v;
        }
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = Arrays.binarySearch(vals, 0, m, nums[i]) + 1;
        }

        bitCnt = new long[m + 1];
        bitSum = new long[m + 1];

        int LOG = Integer.highestOneBit(m);
        int windows = n - x + 1;
        long[] cost = new long[windows];
        long total = 0;
        int medK = (x + 1) / 2;

        for (int i = 0; i < n; i++) {
            update(rank[i], 1, nums[i]);
            total += nums[i];
            if (i >= x) {
                update(rank[i - x], -1, -nums[i - x]);
                total -= nums[i - x];
            }
            if (i >= x - 1) {
                // find medK-th smallest
                int pos = 0;
                long rem = medK;
                for (int pw = LOG; pw > 0; pw >>= 1) {
                    if (pos + pw <= m && bitCnt[pos + pw] < rem) {
                        pos += pw;
                        rem -= bitCnt[pos];
                    }
                }
                long med = vals[pos]; // rank pos+1 -> vals[pos]

                // prefix count and sum up to rank pos+1
                long c = 0, s = 0;
                for (int idx = pos + 1; idx > 0; idx -= idx & -idx) {
                    c += bitCnt[idx];
                    s += bitSum[idx];
                }
                cost[i - x + 1] = med * c - s + (total - s) - med * (x - c);
            }
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[n + 1][k + 1];
        for (long[] row : dp) Arrays.fill(row, INF);
        for (int i = 0; i <= n; i++) dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (i >= x && dp[i - x][j - 1] < INF) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - x][j - 1] + cost[i - x]);
                }
            }
        }
        return dp[n][k];
    }
}