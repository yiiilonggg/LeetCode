class Solution {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        Map<Integer, Integer> seen = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int m = grid.length, n = grid[0].length, mask = (1 << n) - 1;
        for (int i = 0; i < m; i++) {
            int c = colBits(grid[i]);
            if (seen.containsKey(c)) continue;
            seen.put(c, i);
        }
        for (int i = 0; i <= mask; i++) {
            if (!seen.containsKey(i)) continue;
            for (int j = 0; j <= mask; j++) {
                if (!seen.containsKey(j)) continue;
                if ((i & j) == 0) {
                    if (i == j) {
                        res.add(seen.get(i));
                    } else {
                        res.add(Math.min(seen.get(i), seen.get(j)));
                        res.add(Math.max(seen.get(i), seen.get(j)));
                    }
                    return res;
                }
            }
        }
        return res;
    }

    public int colBits(int[] col) {
        int res = 0;
        for (int c : col) {
            res |= c;
            res <<= 1;
        }
        return res >> 1;
    }
}
