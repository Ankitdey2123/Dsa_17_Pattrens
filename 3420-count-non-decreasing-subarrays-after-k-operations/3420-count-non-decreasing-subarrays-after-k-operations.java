class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
                int n = nums.length;
        ArrayDeque<long[]> dq = new ArrayDeque<>(); // {value, count}
        long sumPref = 0, sumNums = 0, ans = 0;
        int r = n - 1;

        for (int l = n - 1; l >= 0; l--) {
            long cnt = 1;
            while (!dq.isEmpty() && dq.peekFirst()[0] <= nums[l]) {
                long[] seg = dq.pollFirst();
                sumPref -= seg[0] * seg[1];
                cnt += seg[1];
            }
            dq.addFirst(new long[]{nums[l], cnt});
            sumPref += (long) nums[l] * cnt;
            sumNums += nums[l];

            while (sumPref - sumNums > k) {
                long[] back = dq.peekLast();
                sumPref -= back[0];
                back[1]--;
                if (back[1] == 0) dq.pollLast();
                sumNums -= nums[r];
                r--;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}