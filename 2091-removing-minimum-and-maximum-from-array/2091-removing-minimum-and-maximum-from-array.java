class Solution {
    public int minimumDeletions(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxres = 0;
        int minres = 0;

        // Find maximum and its index
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxres = i;
            }
        }

        // Find minimum and its index
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minres = i;
            }
        }

        int left = Math.min(maxres, minres);
        int right = Math.max(maxres, minres);
        int n = nums.length;

        // Both from front
        int fromFront = right + 1;

        // Both from back
        int fromBack = n - left;

        // One from front, one from back
        int fromBoth = (left + 1) + (n - right);

        return Math.min(fromFront, Math.min(fromBack, fromBoth));

    }
}