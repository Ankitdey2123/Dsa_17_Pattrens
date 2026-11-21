class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
                int n = parent.length;

        // Build children lists using arrays
        int[] head = new int[n];
        int[] next = new int[n];
        Arrays.fill(head, -1);
        for (int i = 1; i < n; i++) {
            next[i] = head[parent[i]];
            head[parent[i]] = i;
        }

        int[] newParent = new int[n];
        newParent[0] = -1;
        int[] order = new int[n];     // preorder of the original tree
        int cnt = 0;

        // last[c] = closest ancestor on the current path with letter c
        int[] last = new int[26];
        Arrays.fill(last, -1);

        // iterative DFS; saved[x] restores last[s[x]] on exit
        int[] saved = new int[n];
        int[] iter = new int[n];
        int[] stack = new int[n];
        int sp = 0;

        stack[sp++] = 0;
        iter[0] = head[0];
        saved[0] = last[s.charAt(0) - 'a'];
        last[s.charAt(0) - 'a'] = 0;
        order[cnt++] = 0;

        while (sp > 0) {
            int x = stack[sp - 1];
            int child = iter[x];
            if (child == -1) {
                // exit x: restore the previous entry for its letter
                last[s.charAt(x) - 'a'] = saved[x];
                sp--;
            } else {
                iter[x] = next[child];
                int c = s.charAt(child) - 'a';
                // closest ancestor with the same letter (before marking child itself)
                newParent[child] = last[c] != -1 ? last[c] : parent[child];
                saved[child] = last[c];
                last[c] = child;
                iter[child] = head[child];
                order[cnt++] = child;
                stack[sp++] = child;
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = n - 1; i >= 1; i--) {
            int x = order[i];
            ans[newParent[x]] += ans[x];
        }

        return ans;
    }
}