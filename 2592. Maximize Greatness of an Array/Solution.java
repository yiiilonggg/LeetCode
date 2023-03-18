class Solution {
    public int maximizeGreatness(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(nums);
        for (int n : nums) pq.offer(n);
        int res = 0;
        for (int n : nums) {
            while (!pq.isEmpty() && pq.peek() <= n) pq.poll();
            if (pq.isEmpty()) break;
            res++;
            pq.poll();
        }
        return res;
    }
}