class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        int n = costs.length, left = 0, right = costs.length - 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        while (left < candidates) {
            pq.offer(new int[] { costs[left], -1 });
            left++;
        }
        while (right >= Math.max(left, n - candidates)) {
            pq.offer(new int[] { costs[right], 1 });
            right--;
        }
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int[] curr = pq.poll();
            res += 1L * curr[0];
            if (left > right) continue;
            if (curr[1] == -1) {
                pq.offer(new int[] { costs[left], -1 });
                left++;
            } else {
                pq.offer(new int[] { costs[right], 1 });
                right--;
            }
        }
        return res;
    }
}
