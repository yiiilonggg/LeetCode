class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int n = score.length, m = score[0].length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { score[i][k], i });
        }
        int[][] res = new int[n][];
        for (int i = 0; i < n; i++) {
            res[i] = score[pq.poll()[1]];
        }
        return res;
    }
}