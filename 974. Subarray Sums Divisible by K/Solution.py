class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        residues = [0 for i in range(2 * k)]
        prefixSum, res = 0, 0
        for n in nums:
            prefixSum += n
            residue = (prefixSum % k) + k
            if residue == k: res += 1
            if residue < k: res += residues[residue + k]
            if residue > k: res += residues[residue - k]
            res += residues[residue]
            residues[residue] += 1
        return res