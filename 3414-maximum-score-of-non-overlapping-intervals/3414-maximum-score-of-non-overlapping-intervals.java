class Solution {
    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        Interval[] arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort by ending position
        Arrays.sort(arr, (a, b) -> {
            if (a.r != b.r) {
                return Integer.compare(a.r, b.r);
            }
            return Integer.compare(a.idx, b.idx);
        });

        // prev[i] = last interval whose ending point < arr[i].l
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = findPrevious(arr, i);
        }

        // dp[k][i] = best answer using first i intervals and at most k intervals
        State[][] dp = new State[5][n + 1];

        for (int k = 0; k <= 4; k++) {
            for (int i = 0; i <= n; i++) {
                dp[k][i] = new State(0, new ArrayList<>());
            }
        }

        for (int i = 1; i <= n; i++) {

            Interval cur = arr[i - 1];

            for (int k = 1; k <= 4; k++) {

                // Don't take current interval
                State skip = dp[k][i - 1];

                // Take current interval
                int p = prev[i - 1];

                State before = dp[k - 1][p + 1];

                List<Integer> newIndices =
                    new ArrayList<>(before.indices);

                newIndices.add(cur.idx);

                Collections.sort(newIndices);

                State take = new State(
                    before.score + cur.w,
                    newIndices
                );

                dp[k][i] = better(skip, take);
            }
        }

        List<Integer> answer = dp[4][n].indices;

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private int findPrevious(Interval[] arr, int i) {

        int left = 0;
        int right = i - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Strictly less because touching boundaries overlap
            if (arr[mid].r < arr[i].l) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private State better(State a, State b) {

        // Higher score is better
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        // Same score -> lexicographically smaller indices
        return isLexicographicallySmaller(a.indices, b.indices)
            ? a
            : b;
    }

    private boolean isLexicographicallySmaller(
        List<Integer> a,
        List<Integer> b
    ) {

        int len = Math.min(a.size(), b.size());

        for (int i = 0; i < len; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        // If one is a prefix of the other,
        // shorter one is lexicographically smaller.
        return a.size() < b.size();
    }
}