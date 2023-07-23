class Solution {
    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();
        long res = 0;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            graph[parent.get(i)].add(i);
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[] { 0, 0 });
        Map<Integer, Long> masks = new HashMap<>();
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int[] curr = q.pollFirst();
                res += masks.getOrDefault(curr[1], 0L);
                masks.put(curr[1], masks.getOrDefault(curr[1], 0L) + 1);
                for (int j = 0; j < 26; j++) {
                    int nmask = curr[1] ^ (1 << j);
                    res += masks.getOrDefault(nmask, 0L);
                }
                for (int neighbour : graph[curr[0]]) {
                    int nmask = curr[1] ^ (1 << (s.charAt(neighbour) - 'a'));
                    q.offerLast(new int[] { neighbour, nmask });
                }
            }
        }
        return res;
    }
}
