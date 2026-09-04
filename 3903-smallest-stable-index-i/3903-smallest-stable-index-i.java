class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];

        pre[0] = nums[0];
        suf[nums.length - 1] = nums[nums.length - 1];

        // Prefix maximum
        for (int i = 1; i < nums.length; i++) {
            pre[i] = Math.max(pre[i - 1], nums[i]);
        }

        // Suffix minimum
        for (int i = nums.length - 2; i >= 0; i--) {
            suf[i] = Math.min(suf[i + 1], nums[i]);
        }

        // Find first stable index
        for (int i = 0; i < nums.length; i++) {
            if (pre[i] - suf[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}