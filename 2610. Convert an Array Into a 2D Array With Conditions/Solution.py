class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        n, high, res = len(nums), 0, []
        counter = [0 for i in range(n + 1)]
        for i in nums:
            counter[i] += 1
            high = max(high, counter[i])
        for i in range(high):
            curr = []
            for j in range(1, n + 1):
                if counter[j] > 0: curr.append(j)
                counter[j] -= 1
            res.append(curr)
        return res