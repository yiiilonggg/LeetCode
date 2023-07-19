class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0, upper = intervals[0][0] - 1;
        for (int[] i : intervals) {
            if (i[0] < upper) {
                count++;
            } else {
                upper = i[1];
            }
        }
        return count;
    }
}
