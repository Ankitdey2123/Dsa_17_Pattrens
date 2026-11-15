class Solution {
    public int numOfSubarrays(int[] arr) {
             final int MOD = 1_000_000_007;
        long even = 1, odd = 0; // empty prefix counts as even
        int parity = 0;
        long ans = 0;

        for (int a : arr) {
            parity = (parity + a) & 1;
            if (parity == 0) {
                ans += odd;
                even++;
            } else {
                ans += even;
                odd++;
            }
            ans %= MOD;
        }
        return (int) ans;
    }
}