class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        for (int g : gifts) pq.offer((double) g);
        for (int i = 0; i < k; i++) {
            double curr = pq.poll();
            pq.offer(Math.floor(Math.sqrt(curr)));
        }
        long res = 0;
        while (!pq.isEmpty()) {
            res += 1L * pq.poll();
        }
        return res;
    }
}