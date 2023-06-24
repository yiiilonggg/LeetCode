class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int l = queries.length, m = logs.length;
        int[] queriesS = new int[l], res = new int[l];
        Map<Integer, Integer> temp = new HashMap<>(), active = new HashMap<>();
        for (int i = 0; i < l; i++) {
            queriesS[i] = queries[i];
            temp.put(queries[i], i);
        }
        Arrays.sort(logs, (a, b) -> (a[1] - b[1]));
        Arrays.sort(queriesS);
        int left = 0, right = 0;
        for (int q : queriesS) {
            while (left < m && logs[left][1] < q - x) {
                if (active.containsKey(logs[left][0])) {
                    active.put(logs[left][0], active.get(logs[left][0]) - 1);
                    if (active.get(logs[left][0]) == 0) active.remove(logs[left][0]);
                }
                left++;
            }
            right = Math.max(left, right);
            while (right < m && logs[right][1] <= q) {
                active.put(logs[right][0], active.getOrDefault(logs[right][0], 0) + 1);
                right++;
            }
            temp.put(q, n - active.size());
        }
        for (int i = 0; i < l; i++) {
            res[i] = temp.get(queries[i]);
        }
        return res;
    }
}
