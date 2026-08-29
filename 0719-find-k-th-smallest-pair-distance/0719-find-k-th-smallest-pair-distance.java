class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int l = 0;
            for (int r = 0; r < nums.length; r++) {
                while (nums[r] - nums[l] > mid) {
                    l++;
                }
                count += r - l;
            }
            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}