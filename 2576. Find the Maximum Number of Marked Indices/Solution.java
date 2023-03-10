class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, front = 0, back = n / 2, res = 0;
        while (front < n / 2 && back < n) {
            while (back < n && nums[front] * 2 > nums[back]) back++;
            if (back < n) res += 2;
            back++;
            front++;
        }
        return res;
    }
}