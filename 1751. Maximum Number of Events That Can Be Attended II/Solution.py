class Solution:
    def maxValue(self, events: List[List[int]], k: int) -> int:
        events.sort(key = lambda x: (x[0], x[1]))
        self.memo = dict([[i, dict()] for i in range(len(events))])
        return self.r(events, 0, 0, k)
    
    def r(self, events, curr, tot, k):
        if k == 0 or curr == len(events): return tot
        if k in self.memo[curr]: return tot + self.memo[curr][k]
        a = self.r(events, curr + 1, tot, k)
        left, right = curr, len(events)
        while left < right:
            mid = (left + right) // 2
            if events[mid][0] <= events[curr][1]:
                left = mid + 1
            else:
                right = mid
        b = self.r(events, left, tot + events[curr][2], k - 1)
        self.memo[curr][k] = max(a, b) - tot
        return max(a, b)
