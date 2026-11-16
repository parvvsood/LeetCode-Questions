import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;

        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] r : roads) {
            adj.get(r[0]).add(new long[]{r[1], r[2]});
            adj.get(r[1]).add(new long[]{r[0], r[2]});
        }

        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[1], b[1])
        );

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();

            int node = (int) curr[0];
            long d = curr[1];

            if (d > dist[node]) continue;

            for (long[] edge : adj.get(node)) {
                int next = (int) edge[0];
                long newDist = d + edge[1];

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    ways[next] = ways[node];

                    pq.add(new long[]{next, newDist});
                }
                else if (newDist == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}