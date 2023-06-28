class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Set<Integer>> seen = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        pq.offer(new int[] { nums1[0] + nums2[0], 0, 0 });
        seen.put(0, new HashSet<>());
        seen.get(0).add(0);
        while (!pq.isEmpty() && k > 0) {
            int[] curr = pq.poll();
            res.add(new ArrayList<>(List.of(nums1[curr[1]], nums2[curr[2]])));
            k--;
            if (curr[1] < n - 1 && (!seen.containsKey(curr[1] + 1) || !seen.get(curr[1] + 1).contains(curr[2]))) {
                pq.offer(new int[] { nums1[curr[1] + 1] + nums2[curr[2]], curr[1] + 1, curr[2]});
                if (!seen.containsKey(curr[1] + 1)) seen.put(curr[1] + 1, new HashSet<>());
                seen.get(curr[1] + 1).add(curr[2]);
            }
            if (curr[2] < m - 1 && (!seen.containsKey(curr[1]) || !seen.get(curr[1]).contains(curr[2] + 1))) {
                pq.offer(new int[] { nums1[curr[1]] + nums2[curr[2] + 1], curr[1], curr[2] + 1});
                if (!seen.containsKey(curr[1])) seen.put(curr[1], new HashSet<>());
                seen.get(curr[1]).add(curr[2] + 1);
            }
        }
        return res;
    }
}
