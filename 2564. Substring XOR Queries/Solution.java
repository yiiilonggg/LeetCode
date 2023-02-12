class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer, int[]> master = new HashMap<>();
        int n = queries.length, m = s.length();
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == '0') {
                if (!master.containsKey(0)) master.put(0, new int[] { i , i });
                continue;
            }
            for (int j = 1; j <= Math.min(31, m - i); j++) {
                int x = Integer.parseInt(s.substring(i, i + j), 2);
                if (master.containsKey(x)) continue;
                master.put(x, new int[] { i, i + j - 1 });
            }
        }
        int[][] res = new int[n][];
        for (int i = 0; i < n; i++) {
            int target = queries[i][0] ^ queries[i][1];
            if (master.containsKey(target)) {
                res[i] = master.get(target);
            } else {
                res[i] = new int[] { -1, -1 };
            }
        }
        return res;
    }
}