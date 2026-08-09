class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
  HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        // Store nums1 in HashSet
        for (int num : nums1) {
            set.add(num);
        }

        // Find common elements
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        // Convert HashSet to int[]
        int[] arr = new int[result.size()];

        int i = 0;

        for (int num : result) {
            arr[i] = num;
            i++;
        }

        return arr;
        
    }
}