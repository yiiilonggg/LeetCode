class Solution {
    Map<Integer, Map<Integer, Double>> memo;
    public double soupServings(int n) {
        int m = (int) Math.ceil(1D * n / 25);
        memo = new HashMap<>();
        for (int i = 1; i < m + 1; i++) {
            if (r(i, i) > 1 - 0.00001) return 1;
        }
        return r(m, m);
    }
    public double r(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1;
        if (b <= 0) return 0;
        if (memo.containsKey(a) && memo.get(a).containsKey(b)) return memo.get(a).get(b);
        double w = r(a - 4, b), x = r(a - 3, b - 1), y = r(a - 2, b - 2), z = r(a - 1, b - 3);
        if (!memo.containsKey(a)) memo.put(a, new HashMap<>());
        memo.get(a).put(b, 0.25 * (w + x + y + z));
        return memo.get(a).get(b);
    }
}
