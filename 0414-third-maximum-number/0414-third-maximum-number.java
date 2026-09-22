class Solution {
    public int thirdMax(int[] nums) {
 long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            long current = nums[i];

            // Ignore duplicate
            if (current == first ||
                current == second ||
                current == third) {
                continue;
            }

            // Current becomes the biggest
            if (current > first) {
                third = second;
                second = first;
                first = current;
            }

            // Current becomes second biggest
            else if (current > second) {
                third = second;
                second = current;
            }

            // Current becomes third biggest
            else if (current > third) {
                third = current;
            }
        }

        // No third distinct maximum
        if (third == Long.MIN_VALUE) {
            return (int) first;
        }

        return (int) third;

    }
}