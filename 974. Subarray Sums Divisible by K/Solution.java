class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] residues = new int[2 * k];
        int prefixSum = 0, res = 0, residue;
        for (int n : nums) {
            prefixSum += n;
            residue = (prefixSum % k) + k;
            if (residue == k) res++;
            if (residue < k) res += residues[residue + k];
            if (residue > k) res += residues[residue - k];
            res += residues[residue];
            residues[residue]++;
        }
        return res;
    }
}