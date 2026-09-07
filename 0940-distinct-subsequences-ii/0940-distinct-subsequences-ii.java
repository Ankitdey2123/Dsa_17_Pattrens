class Solution {
    public int distinctSubseqII(String s) {
                int MOD = 1000000007;
        long[] dp = new long[26];
        long total = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';

            long newSubseq = (total + 1) % MOD;

            total = (total + newSubseq - dp[idx] + MOD) % MOD;
            dp[idx] = newSubseq;
        }

        return (int) total;
    }
}