class Solution {
    public boolean scoreBalance(String s) {
                int n = s.length();
        int[] pre = new int[n];

        // Calculate prefix scores
        pre[0] = s.charAt(0) - 'a' + 1;

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + (s.charAt(i) - 'a' + 1);
        }

        // Total score
        int total = pre[n - 1];

        // Check every possible split
        for (int i = 0; i < n - 1; i++) {
            int left = pre[i];
            int right = total - pre[i];

            if (left == right) {
                return true;
            }
        }

        return false;
        
    }
}