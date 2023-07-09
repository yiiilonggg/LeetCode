class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> d = new HashSet<>();
        int l = moveFrom.length;
        for (int n : nums) d.add(n);
        for (int i = 0; i < l; i++) {
            if (moveFrom[i] == moveTo[i]) continue;
            d.add(moveTo[i]);
            d.remove(moveFrom[i]);
        }
        List<Integer> res = new ArrayList<>(d);
        res.sort((a, b) -> a - b);
        return res;
    }
}
