class KthLargest {
    int K;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        K = k;
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() == K + 1) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() == K + 1) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
