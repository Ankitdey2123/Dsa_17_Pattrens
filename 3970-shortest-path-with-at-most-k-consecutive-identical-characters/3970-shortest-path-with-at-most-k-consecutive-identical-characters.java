class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
               int m = edges.length;
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] nxt = new int[m];
        int[] to = new int[m];
        int[] wt = new int[m];
        for (int i = 0; i < m; i++) {
            to[i] = edges[i][1];
            wt[i] = edges[i][2];
            nxt[i] = head[edges[i][0]];
            head[edges[i][0]] = i;
        }

        char[] lab = labels.toCharArray();
        long S = (long) n * k;              // number of states
        long INF = Long.MAX_VALUE;
        long[] dist = new long[(int) S];
        Arrays.fill(dist, INF);

        // state = u * k + (run - 1)
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[0] = 0;                        // node 0, run 1
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int state = (int) cur[1];
            if (d > dist[state]) continue;

            int u = state / k;
            int run = state % k + 1;
            if (u == n - 1) return (int) d;  // first time popping target is optimal

            for (int e = head[u]; e != -1; e = nxt[e]) {
                int v = to[e];
                int nr;
                if (lab[v] == lab[u]) {
                    nr = run + 1;
                    if (nr > k) continue;
                } else {
                    nr = 1;
                }
                int ns = v * k + (nr - 1);
                long nd = d + wt[e];
                if (nd < dist[ns]) {
                    dist[ns] = nd;
                    pq.add(new long[]{nd, ns});
                }
            }
        }
        return -1;
    }
}