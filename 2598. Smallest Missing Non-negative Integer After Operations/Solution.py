class Solution:
    def findSmallestInteger(self, nums: List[int], value: int) -> int:
        counter = [0 for i in range(value)]
        for n in nums:
            if n < 0:
                if n % value == 0:
                    counter[0] += 1
                else:
                    counter[value - (-n % value)] += 1
            else:
                counter[n % value] += 1
        low, pos = len(nums), 0
        for i in range(value):
            if counter[i] == 0: return i
            if counter[i] < low:
                low, pos = counter[i], i
        return value * low + pos