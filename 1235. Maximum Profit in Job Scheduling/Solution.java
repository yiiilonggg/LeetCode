class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (int[] j : jobs) {
            int curr = dp.floorEntry(j[0]).getValue() + j[2];
            if (curr > dp.lastEntry().getValue()) {
                dp.put(j[1], curr);
            }
        }
        return dp.lastEntry().getValue();
    }
}
