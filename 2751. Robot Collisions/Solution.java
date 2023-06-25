class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] comb = new int[n][3];
        for (int i = 0; i < n; i++) {
            comb[i][0] = positions[i];
            comb[i][1] = healths[i];
            comb[i][2] = (int) (directions.charAt(i) - 'L');
        }
        Arrays.sort(comb, (a, b) -> (a[0] - b[0]));
        Map<Integer, Integer> res = new HashMap<>();
        int i = 0;
        while (i < n && comb[i][2] == 0) {
            res.put(comb[i][0], comb[i][1]);
            i++;
        }
        Deque<int[]> stack = new ArrayDeque<>();
        while (i < n) {
            if (comb[i][2] != 0) {
                stack.offerLast(comb[i]);
            } else {
                boolean flag = false;
                while (!stack.isEmpty()) {
                    if (stack.peekLast()[1] == comb[i][1]) {
                        stack.pollLast();
                        flag = true;
                        break;
                    } else if (stack.peekLast()[1] < comb[i][1]) {
                        comb[i][1]--;
                        stack.pollLast();
                    } else {
                        stack.peekLast()[1]--;
                        break;
                    }
                }
                if (stack.isEmpty() && !flag) {
                    res.put(comb[i][0], comb[i][1]);
                }
            }
            i++;
        }
        for (int[] s : stack) res.put(s[0], s[1]);
        List<Integer> f = new ArrayList<>();
        for (int p : positions) {
            if (res.containsKey(p)) f.add(res.get(p));
        }
        return f;
    }
}
