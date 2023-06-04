class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        Map<Integer, Set<Integer>> seen = new HashMap<>();
        int rows = 0, cols = 0;
        long res = 0;
        for (int i = queries.length - 1; i >= 0 && rows < n && cols < n; i--) {
            int t = queries[i][0], idx = queries[i][1], val = queries[i][2];
            if (seen.containsKey(t) && seen.get(t).contains(idx)) continue;
            if (!seen.containsKey(t)) seen.put(t, new HashSet<>());
            seen.get(t).add(idx);
            if (t == 0) {
                rows++;
                res += val * (n - cols);
            } else {
                cols++;
                res += val * (n - rows);
            }
        }
        return res;
    }
}
