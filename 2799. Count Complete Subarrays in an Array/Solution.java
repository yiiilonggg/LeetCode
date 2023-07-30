class Solution {
    int res = 0, n;
    Map<Integer, Integer> counter = new HashMap<>();
    Map<Integer, Set<Integer>> seen = new HashMap<>();
    public int countCompleteSubarrays(int[] nums) {
        for (int num : nums) counter.put(num, counter.getOrDefault(num, 0) + 1);
        n = counter.size();
        int m = nums.length;
        if (n == 1) return m * (m + 1) / 2;
        if (n == m) return 1;
        count(nums, 0, m - 1);
        return res;
    } 
    public void count(int[] nums, int left, int right) {
        if (left > right) return;
        if (seen.containsKey(left) && seen.get(left).contains(right)) return;
        if (!seen.containsKey(left)) seen.put(left, new HashSet<>());
        seen.get(left).add(right);
        if (counter.size() < n) return;
        res++;
        counter.put(nums[left], counter.get(nums[left]) - 1);
        if (counter.get(nums[left]) == 0) counter.remove(nums[left]);
        count(nums, left + 1, right);
        counter.put(nums[left], counter.getOrDefault(nums[left], 0) + 1);
        counter.put(nums[right], counter.get(nums[right]) - 1);
        if (counter.get(nums[right]) == 0) counter.remove(nums[right]);
        count(nums, left, right - 1);
        counter.put(nums[right], counter.getOrDefault(nums[right], 0) + 1);
    }
}
