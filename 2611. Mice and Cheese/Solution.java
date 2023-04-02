class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - b[1]) - (a[0] - a[1]));
        int n = reward1.length, res = 0;
        for (int i = 0; i < n; i++) pq.offer(new int[] { reward1[i], reward2[i] });
        for (int i = 0; i < k; i++) res += pq.poll()[0];
        while (!pq.isEmpty()) res += pq.poll()[1];
        return res;
    }
}