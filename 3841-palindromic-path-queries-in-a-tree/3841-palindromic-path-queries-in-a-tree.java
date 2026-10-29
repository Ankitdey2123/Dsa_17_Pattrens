class Solution {
    int[] bit;
    int size;

    void upd(int i, int d) {
        for (; i <= size; i += i & -i) bit[i] ^= d;
    }

    int qry(int i) {
        int r = 0;
        for (; i > 0; i -= i & -i) r ^= bit[i];
        return r;
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        // adjacency list
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int LOG = 1;
        while ((1 << LOG) < n) LOG++;
        int[][] up = new int[LOG + 1][n];
        int[] depth = new int[n];
        int[] tin = new int[n];
        int[] tout = new int[n];

        // iterative DFS from root 0
        int[] stack = new int[n];
        int[] idx = new int[n];
        int sp = 0, timer = 0;
        stack[sp++] = 0;
        up[0][0] = 0;
        tin[0] = ++timer;
        while (sp > 0) {
            int u = stack[sp - 1];
            if (idx[u] < adj[u].size()) {
                int v = adj[u].get(idx[u]++);
                if (v == up[0][u] && u != 0) continue;
                if (u == 0 && v == 0) continue;
                up[0][v] = u;
                depth[v] = depth[u] + 1;
                tin[v] = ++timer;
                stack[sp++] = v;
            } else {
                tout[u] = timer;
                sp--;
            }
        }

        for (int k = 1; k <= LOG; k++) {
            for (int v = 0; v < n; v++) {
                up[k][v] = up[k - 1][up[k - 1][v]];
            }
        }

        // BIT setup
        size = n + 1;
        bit = new int[size + 1];
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            mask[i] = 1 << (s.charAt(i) - 'a');
            upd(tin[i], mask[i]);
            upd(tout[i] + 1, mask[i]);
        }

        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            String[] p = q.split(" ");
            if (p[0].equals("update")) {
                int x = Integer.parseInt(p[1]);
                int nm = 1 << (p[2].charAt(0) - 'a');
                int d = mask[x] ^ nm;
                if (d != 0) {
                    upd(tin[x], d);
                    upd(tout[x] + 1, d);
                    mask[x] = nm;
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                // LCA
                int a = u, b = v;
                if (depth[a] < depth[b]) { int t = a; a = b; b = t; }
                int diff = depth[a] - depth[b];
                for (int k = 0; k <= LOG; k++) {
                    if (((diff >> k) & 1) != 0) a = up[k][a];
                }
                int lca;
                if (a == b) {
                    lca = a;
                } else {
                    for (int k = LOG; k >= 0; k--) {
                        if (up[k][a] != up[k][b]) {
                            a = up[k][a];
                            b = up[k][b];
                        }
                    }
                    lca = up[0][a];
                }

                int res = qry(tin[u]) ^ qry(tin[v]) ^ mask[lca];
                ans.add((res & (res - 1)) == 0);
            }
        }
        return ans;
    }
}