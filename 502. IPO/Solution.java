class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length, pointer = 0;
        int[][] combined = new int[n][];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) combined[i] = new int[] { capital[i], profits[i] };
        Arrays.sort(combined, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < k; i++) {
            while (pointer < n && combined[pointer][0] <= w) {
                pq.offer(combined[pointer][1]);
                pointer++;
            }
            if (pq.isEmpty()) break;
            w += pq.poll();
        }
        return w;
    }
}