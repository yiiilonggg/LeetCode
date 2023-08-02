class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        int[] foll = new int[nums.length - 1];
        int push = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    push--;
                    continue;
                }
                foll[j + push] = nums[j];
            }
            push = 0;
            for (List<Integer> prev : permute(foll)) {
                prev.add(nums[i]);
                res.add(prev);
            }
        }
        return res;
    }
}
