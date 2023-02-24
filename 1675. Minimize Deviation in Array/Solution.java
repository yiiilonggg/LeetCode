class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int low = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n % 2 == 1) n <<= 1;
            pq.offer(n);
            low = Math.min(low, n);
        }
        while (true) {
            int curr = pq.poll();
            res = Math.min(res, curr - low);
            if (curr % 2 == 1) break;
            low = Math.min(low, curr >> 1);
            pq.offer(curr >> 1);
        }
        return res;
    }
}