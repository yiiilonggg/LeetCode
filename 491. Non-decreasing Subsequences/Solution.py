class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.backtrack(0, nums, [])
        return self.res

    def backtrack(self, curr, nums, currList):
        if len(currList) > 1: self.res.append([i for i in currList])
        seen = set()
        for i in range(curr, len(nums)):
            if (len(currList) >= 1 and nums[i] < currList[-1]) or nums[i] in seen: continue
            currList.append(nums[i])
            seen.add(nums[i])
            self.backtrack(i + 1, nums, currList)
            currList.pop()