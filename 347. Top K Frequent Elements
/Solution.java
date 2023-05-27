class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length, pointer = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        List<Integer>[] buckets = new List[n + 1];
        int[] res = new int[k];
        for (int i = 0; i < n + 1; i++) buckets[i] = new ArrayList<>();
        for (int num : nums) seen.put(num, seen.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer, Integer> pair : seen.entrySet()) {
            buckets[pair.getValue()].add(pair.getKey());
        }
        for (int i = n; i >= 0 && k > 0; i--) {
            if (buckets[i].size() == 0) continue;
            for (int j : buckets[i]) {
                res[pointer] = j;
                pointer++;
            }
            k -= buckets[i].size();
        }
        return res;
    }
}
