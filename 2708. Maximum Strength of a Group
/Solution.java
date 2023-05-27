class Solution {
    public long maxStrength(int[] nums) {
        if (nums.length == 1) return nums[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long res = 1;
        int count = 0;
        for (int n : nums) {
            if (n >= 1) {
                res *= n;
                count++;
            } else {
                pq.offer(n);
            }
        }
        while (pq.size() > 1) {
            int curr = pq.poll();
            if (curr < 0) {
                if (pq.peek() < 0) {
                    res *= 1L * curr * pq.poll();
                    count += 2;
                } else {
                    if (count == 0) res = 0;
                }
            } else {
                if (count == 0) res = 0;
            }
        }
        return res;
    }
}
