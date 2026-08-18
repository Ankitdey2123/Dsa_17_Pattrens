class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        int maxCount = -1;
        HashMap<Integer, Integer> window = new LinkedHashMap<>();
        for (int i = 0; i < k; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int i : map.keySet()) {
            if (window.containsKey(i)) {
                window.put(i, window.get(i) + 1);
            } else {
                window.put(i, 1);
            }
        }

        for (int i = k; i < nums.length; i++) {
            if (map.get(nums[i - k]) == 1) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
            }
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            for (int n : map.keySet()) {
                if (window.containsKey(n)) {
                    window.put(n, window.get(n) + 1);
                } else {
                    window.put(n, 1);
                }
            }

        }
                for (int n : window.keySet()) {
                if (window.get(n) == 1) {
                    maxCount = Math.max(maxCount, n);
                }
            }
        return maxCount;
    }
}