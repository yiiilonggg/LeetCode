class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp = new ArrayList<>();
        for (int[] i : intervals) {
            if (i[1] < newInterval[0]) {
                temp.add(newInterval);
                newInterval = i;
            } else if (i[0] > newInterval[1]) {
                temp.add(i);
            } else {
                newInterval[0] = Math.min(newInterval[0], i[0]);
                newInterval[1] = Math.max(newInterval[1], i[1]);
            }
        }
        temp.add(newInterval);
        int n = temp.size();
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) res[i] = temp.get(i);
        return res;
    }
}