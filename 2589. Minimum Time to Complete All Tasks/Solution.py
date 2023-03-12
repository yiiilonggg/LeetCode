class Solution:
    def findMinimumTime(self, tasks: List[List[int]]) -> int:
        tasks = sorted(tasks, key = itemgetter(1))
        on = [False for i in range(2001)]
        count = 0
        for x, y, z in tasks:
            curr = 0
            for i in range(x, y + 1):
                if on[i]: curr += 1
            for i in range(y, x - 1, -1):
                if curr >= z: break
                if on[i]: continue
                on[i] = True
                count += 1
                curr += 1
        return count