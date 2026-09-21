class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];

        // dp[r] = number of subarrays ending at the previous position
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {
            int val = num % k;
            long[] next = new long[k];

            // Start a new subarray with nums[i]
            next[val]++;

            // Extend every previous subarray
            for (int r = 0; r < k; r++) {
                if (dp[r] != 0) {
                    int nr = (int) ((long) r * val % k);
                    next[nr] += dp[r];
                }
            }

            // Every non-empty contiguous subarray corresponds
            // to exactly one operation (remove its prefix and suffix).
            for (int r = 0; r < k; r++) {
                ans[r] += next[r];
            }

            dp = next;
        }

        return ans;
    }
}