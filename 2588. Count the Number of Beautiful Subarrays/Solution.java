class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        int prefixXOR = 0;
        long res = 0;
        for (int n : nums) {
            prefixXOR ^= n;
            if (prefixXOR == 0) res++;
            res += counter.getOrDefault(prefixXOR, 0);
            counter.put(prefixXOR, counter.getOrDefault(prefixXOR, 0) + 1);
        }
        return res;
    }
}