class Solution {
    public int minOperations(String s) {
                int n = s.length();
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        if (n == 2) return -1;

        char min = 'z', max = 'a';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < min) min = c;
            if (c > max) max = c;
        }

        // Sort the suffix s[1..n-1]
        if (s.charAt(0) == min) return 1;
        // Sort the prefix s[0..n-2]
        if (s.charAt(n - 1) == max) return 1;

        // Need to check whether min occurs anywhere except the last index,
        // and max occurs anywhere except the first index.
        boolean minElsewhere = false;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == min) {
                minElsewhere = true;
                break;
            }
        }
        boolean maxElsewhere = false;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == max) {
                maxElsewhere = true;
                break;
            }
        }

        // If the min is only at the last index and the max is only at the
        // first index, we need 3 operations; otherwise 2.
        if (!minElsewhere && !maxElsewhere) return 3;
        return 2;
    }
}