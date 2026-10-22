class Solution {
    public int minOperations(int[] nums) {
               int n = nums.length;
        int k = nums[0];

        boolean asc = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (k + i) % n) {
                asc = false;
                break;
            }
        }
        if (asc) {
            if (k == 0) return 0;
            return Math.min(n - k, k + 2);
        }

        boolean desc = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != ((k - i) % n + n) % n) {
                desc = false;
                break;
            }
        }
        if (desc) {
            int s = (k + 1) % n;
            return 1 + Math.min(s, (n - s) % n);
        }

        return -1;
    }
}