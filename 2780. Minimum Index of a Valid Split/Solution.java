class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> d = new HashMap<>();
        int x = 0, high = 0, n = nums.size();
        for (int num : nums) {
            d.put(num, d.getOrDefault(num, 0) + 1);
            if (d.get(num) > high) {
                high = d.get(num);
                x = num;
            }
        }
        int left = 0, right = high;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == x) {
                left++;
                right--;
            }
            if (left > (i + 1) / 2 && right > (n - i - 1) / 2) return i;
        }
        return -1;        
    }
}
