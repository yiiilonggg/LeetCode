class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        int count = 0;
        boolean[] on = new boolean[2001];
        for (int[] t : tasks) {
            int start = t[0], end = t[1], time = t[2], curr = 0;
            for (int i = start; i <= end; i++) {
                if (on[i]) curr++;
            }
            for (int i = end; curr < time && i >= start; i--) {
                if (on[i]) continue;
                on[i] = true;
                count++;
                curr++;
            }
        }
        return count;
    }
}