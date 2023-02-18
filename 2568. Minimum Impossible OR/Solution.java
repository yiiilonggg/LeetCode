class Solution {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) seen.add(n);
        int poll;
        for (poll = 1; poll <= Integer.MAX_VALUE; poll <<= 1) {
            if (seen.contains(poll)) continue;
            return poll;
        }
        return -1;
    }
}