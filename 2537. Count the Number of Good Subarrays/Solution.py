class Solution:
    def countGood(self, nums: List[int], k: int) -> int:
        res, pairs, right, n = 0, 0, 0, len(nums)
        counter = dict()
        for left in range(n):
            while right < n and pairs < k:
                if nums[right] not in counter: counter[nums[right]] = 0
                pairs += counter[nums[right]]
                counter[nums[right]] += 1
                right += 1
            if pairs >= k:
                res += n - right + 1
            pairs -= counter[nums[left]] - 1
            counter[nums[left]] -= 1
        return res