class Solution {
    Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < events.length; i++) memo.put(i, new HashMap<>());
        return r(events, 0, 0, k);
    }
    public int r(int[][] events, int curr, int tot, int k) {
        if (k == 0 || curr == events.length) return tot;
        if (memo.get(curr).containsKey(k)) return tot + memo.get(curr).get(k);
        int a = r(events, curr + 1, tot, k);
        int left = curr, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= events[curr][1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int b = r(events, left, tot + events[curr][2], k - 1);
        memo.get(curr).put(k, Math.max(a, b) - tot);
        return Math.max(a, b);
    }
}
