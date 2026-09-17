class Solution {
    public int minSumOfLengths(int[] arr, int target) {
               int n = arr.length;
        int INF = Integer.MAX_VALUE / 2;
        
        // best[i] = minimum length of a valid subarray
        // completely within arr[0..i]
        int[] best = new int[n];
        java.util.Arrays.fill(best, INF);

        int ans = INF;
        int left = 0;
        long sum = 0;
        int minLen = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target && left <= right) {
                sum -= arr[left++];
            }

            // Since all arr[i] > 0, sum == target gives one valid subarray.
            if (sum == target) {
                int len = right - left + 1;

                // Combine with the best subarray ending before 'left'.
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                minLen = Math.min(minLen, len);
            }

            best[right] = minLen;
        }

        return ans == INF ? -1 : ans;
    }
}