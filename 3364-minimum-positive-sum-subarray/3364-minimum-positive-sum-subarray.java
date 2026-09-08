class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        // Prefix sum
        int[] pre = new int[n];

        pre[0] = nums.get(0);

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums.get(i);
        }

        int ans = Integer.MAX_VALUE;

        // Length of subarray: l to r
        for (int len = l; len <= r; len++) {

            // Starting index
            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;

                int sum;

                if (i == 0) {
                    sum = pre[j];
                } else {
                    sum = pre[j] - pre[i - 1];
                }

                if (sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}