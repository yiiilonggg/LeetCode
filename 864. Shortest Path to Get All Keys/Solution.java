class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        Map<Integer, Map<Integer, Set<Integer>>> seen = new HashMap<>();
        int[][] movement = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Deque<int[]> q = new ArrayDeque<>();
        int moves = 0, keys = 0, locks = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '@') {
                    q.offerLast(new int[] { 0, i, j });
                } else if (Character.isAlphabetic(grid[i].charAt(j))) {
                    if (Character.isLowerCase(grid[i].charAt(j))) {
                        keys |= (1 << (grid[i].charAt(j) - 'a'));
                    } else {
                        locks |= (1 << (grid[i].charAt(j) - 'A'));
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int[] curr = q.pollFirst();
                int currKeys = curr[0], x = curr[1], y = curr[2];
                if (currKeys == keys) return moves;
                if (seen.containsKey(currKeys)) {
                    if (seen.get(currKeys).containsKey(x)) {
                        if (seen.get(currKeys).get(x).contains(y)) continue;
                    } else {
                        seen.get(currKeys).put(x, new HashSet<>());
                    }
                } else {
                    seen.put(currKeys, new HashMap<>());
                    seen.get(currKeys).put(x, new HashSet<>());
                }
                seen.get(currKeys).get(x).add(y);
                for (int[] move : movement) {
                    int nx = x + move[0], ny = y + move[1];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                    if (grid[nx].charAt(ny) == '#') continue;
                    if (seen.containsKey(currKeys) && seen.get(currKeys).containsKey(nx) && seen.get(currKeys).get(nx).contains(ny))  continue;
                    if (Character.isAlphabetic(grid[nx].charAt(ny))) {
                        if (Character.isUpperCase(grid[nx].charAt(ny))) {
                            if (((1 << (grid[nx].charAt(ny) - 'A')) & currKeys) == 0) continue;
                            q.offerLast(new int[] { currKeys, nx, ny });
                        } else {
                            if (((1 << (grid[nx].charAt(ny) - 'a')) & currKeys) != 0) {
                                q.offerLast(new int[] { currKeys, nx, ny });
                            } else {
                                q.offerLast(new int[] { (1 << (grid[nx].charAt(ny) - 'a')) | currKeys, nx, ny });
                            }
                        }
                    } else {
                        q.offerLast(new int[] { currKeys, nx, ny });
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
