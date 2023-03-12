class Solution:
    def beautifulSubarrays(self, nums: List[int]) -> int:
        counter = dict()
        prefixXOR, count = 0, 0
        for n in nums:
            prefixXOR ^= n
            if prefixXOR == 0: count += 1
            if prefixXOR in counter:
                count += counter[prefixXOR]
                counter[prefixXOR] += 1
            else:
                counter[prefixXOR] = 1
        return count