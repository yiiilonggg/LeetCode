class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        for (int i = k; i < n + 1; i++) {
            for (List<Integer> prev : combine(i - 1, k - 1)) {
                prev.add(i);
                res.add(prev);
            }
        }
        return res;
    }
}
