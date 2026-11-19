class Solution {
    public int minimizeSum(int[] nums) {
                Arrays.sort(nums);
        int n = nums.length;

        int option1 = nums[n - 1] - nums[2];      // remove two smallest
        int option2 = nums[n - 2] - nums[1];      // remove smallest and largest
        int option3 = nums[n - 3] - nums[0];      // remove two largest

        return Math.min(option1, Math.min(option2, option3));
    }
}