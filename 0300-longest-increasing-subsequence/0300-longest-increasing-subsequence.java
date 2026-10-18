class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int l = 0;
            int r = size;

            while (l < r) {
                int mid = l + (r - l) / 2;

                if (tail[mid] < current) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            tail[l] = current;

            if (l == size) {
                size++;
            }
        }
        return size;
    }
}