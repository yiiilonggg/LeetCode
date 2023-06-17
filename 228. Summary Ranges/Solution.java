class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        List<String> res = new ArrayList<>();
        while (left < n && right < n) {
            if (right + 1 < n && nums[right] + 1 == nums[right + 1]) {
                right++;
            } else {
                StringBuilder str = new StringBuilder();
                if (right == left) {
                    str.append(nums[left]);
                } else {
                    str.append(nums[left]);
                    str.append("->");
                    str.append(nums[right]);
                }
                res.add(str.toString());
                left = right + 1;
                right++;
            }
        }
        return res;
    }
}
