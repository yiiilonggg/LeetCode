class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int n = nums.length;
        for (int i = 0; i < n; i++) pq.offer(new int[] { nums[i], i });
        boolean[] marked = new boolean[n];
        long res = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (marked[curr[1]]) continue;
            res += curr[0];
            if (curr[1] > 0) marked[curr[1] - 1] = true;
            if (curr[1] < n - 1) marked[curr[1] + 1] = true;
            marked[curr[1]] = true;
        }
        return res;
    }
}