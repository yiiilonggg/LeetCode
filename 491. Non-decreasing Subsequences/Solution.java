class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>());
        return res;
    }
    public void backtrack(int curr, int[] nums, List<Integer> currList) {
        if (currList.size() > 1) res.add(new ArrayList<>(currList));
        Set<Integer> seen = new HashSet<>();
        for (int i = curr; i < nums.length; i++) {
            if ((currList.size() >= 1 && nums[i] < currList.get(currList.size() - 1)) || seen.contains(nums[i])) continue;
            currList.add(nums[i]);
            seen.add(nums[i]);
            backtrack(i + 1, nums, currList);
            currList.remove(currList.size() - 1);
        }
    }
}