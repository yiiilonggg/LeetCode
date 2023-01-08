class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        for (int n : nums) pq.offer((long) n);
        long score = 0;
        while (k > 0) {
            long curr = pq.poll();
            score += curr;
            pq.offer((curr + 2) / 3);
            k--;
        }
        return score;
    }
}