class Solution {
    public void sortColors(int[] nums) {
   
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                // Put 0 on the left
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            }

            else if (nums[mid] == 1) {
                // 1 is already in the middle
                mid++;
            }

            else {
                // Put 2 on the right
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
                // mid does NOT increase here
            }

        }
        
    }
}