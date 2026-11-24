class Solution {
    public int maxLength(int[] nums) {
  int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long g = 0;
            long l = 1;

            for (int j = i; j < n; j++) {
                prod *= nums[j];
                if (prod > 25200) {
                    break; // can never be valid again for this start
                }

                g = gcd(g, nums[j]);
                l = l / gcd(l, nums[j]) * nums[j];

                if (prod == l * g) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}