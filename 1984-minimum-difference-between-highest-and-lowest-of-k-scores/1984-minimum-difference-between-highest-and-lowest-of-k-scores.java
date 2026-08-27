class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        for (int left = 0; left <= nums.length - k; left++) {

            int right = left + k - 1;

            int difference = nums[right] - nums[left];

            min = Math.min(min, difference);
        }

        return min;
    }
}