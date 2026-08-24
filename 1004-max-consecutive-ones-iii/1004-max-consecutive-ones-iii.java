class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxCount = 0;
        int count = 0;
        int zeroCount = 0;
        HashMap<Integer, Integer>map = new LinkedHashMap<>();
        for (int right = 0; right < nums.length; right++) {
            if (map.containsKey(nums[right])) {
                map.put(nums[right], map.get(nums[right]) + 1);
            } else {
                map.put(nums[right], 1);
            }
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (map.get(nums[left]) == 1) {
                    if (nums[left] == 0) {
                        zeroCount--;
                    }
                    map.remove(nums[left]);
                } else {
                    if (nums[left] == 0) {
                        zeroCount--;
                    }
                    map.put(nums[left], map.get(nums[left]) - 1);
                }
                left++;
            }
            count=right-left+1;
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}