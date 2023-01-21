class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, i;
        long total = 0, res = Long.MIN_VALUE;
        int[][] combined = new int[n][2];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (i = 0; i < n; i++) {
            combined[i][0] = nums1[i];
            combined[i][1] = nums2[i];
        }
        Arrays.sort(combined, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return b[1] - a[1];
        });
        for (i = 0; i < n; i++) {
            q.offer(combined[i][0]);
            total += combined[i][0];
            if (i >= k) total -= q.poll();
            if (i >= k - 1) res = Math.max(res, total * combined[i][1]);
        }
        return res;
    }
}