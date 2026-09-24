class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        // Find maximum pile
        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        while (l <= r) {

            // Current eating speed
            int mid = l + (r - l) / 2;

            // Total hours required at this speed
            long hours = 0;

            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            // Speed works, try a smaller speed
            if (hours <= h) {
                r = mid - 1;
            }

            // Speed is too slow, increase it
            else {
                l = mid + 1;
            }
        }

        return l;
    }
}