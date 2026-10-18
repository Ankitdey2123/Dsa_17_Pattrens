class Solution {
    int MOD = 1000000007;
    long[][] dp;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        dp = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return (int) ((countWays(list) - 1 + MOD) % MOD);
    }

    long countWays(List<Integer> nums) {
        int n = nums.size();

        if (n <= 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        long leftWays = countWays(left);
        long rightWays = countWays(right);

        long combinations = dp[n - 1][left.size()];

        return (((combinations * leftWays) % MOD) * rightWays) % MOD;
}
}