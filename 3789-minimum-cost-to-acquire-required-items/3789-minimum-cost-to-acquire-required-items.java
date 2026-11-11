class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
              long best = Long.MAX_VALUE;
        long[] candidates = {0, Math.min(need1, need2), Math.max(need1, need2)};

        for (long b : candidates) {
            long total = b * costBoth
                       + Math.max(0L, need1 - b) * cost1
                       + Math.max(0L, need2 - b) * cost2;
            best = Math.min(best, total);
        }
        return best;
    }
}