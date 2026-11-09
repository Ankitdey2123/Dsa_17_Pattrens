class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
                TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) available.add(i);

        // busy: {finishTime, serverId}
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            // free up servers that have finished
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                available.add((int) busy.poll()[1]);
            }

            if (available.isEmpty()) continue;

            Integer server = available.ceiling(i % k);
            if (server == null) server = available.first();

            available.remove(server);
            count[server]++;
            busy.offer(new long[]{(long) arrival[i] + load[i], server});
        }

        int max = 0;
        for (int c : count) max = Math.max(max, c);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) res.add(i);
        }
        return res;

    }
}