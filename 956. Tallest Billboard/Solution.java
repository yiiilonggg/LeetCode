class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length, res = 0;
        Map<Integer, Integer> first = split(rods, 0, n / 2), second = split(rods, n / 2, n);
        for (Map.Entry<Integer, Integer> pair : first.entrySet()) {
            if (second.containsKey(-pair.getKey())) {
                res = Math.max(res, pair.getValue() + second.get(-pair.getKey()));
            }
        }
        return res;
    }

    public Map<Integer, Integer> split(int[] rods, int start, int end) {
        Set<Pair<Integer, Integer>> states = new HashSet<>();
        states.add(new Pair(0, 0));
        for (int i = start; i < end; i++) {
            Set<Pair<Integer, Integer>> curr = new HashSet<>();
            for (Pair<Integer, Integer> p : states) {
                curr.add(new Pair(p.getKey() + rods[i], p.getValue()));
                curr.add(new Pair(p.getKey(), p.getValue() + rods[i]));
            }
            states.addAll(curr);
        }
        Map<Integer, Integer> dp = new HashMap<>();
        for (Pair<Integer, Integer> p : states) {
            dp.put(p.getKey() - p.getValue(), Math.max(dp.getOrDefault(p.getKey() - p.getValue(), 0), p.getKey()));
        }
        return dp;
    }
}
