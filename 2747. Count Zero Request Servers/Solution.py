class Solution:
    def countServers(self, n: int, logs: List[List[int]], x: int, queries: List[int]) -> List[int]:
        l, m = len(queries), len(logs)
        tmp = dict([[q, 0] for q in queries])
        logs = sorted(logs, key = itemgetter(1))
        left, right = 0, 0
        active = dict()
        for q in sorted(tmp.keys()):
            while left < m and logs[left][1] < q - x:
                if logs[left][0] in active:
                    active[logs[left][0]] -= 1
                    if active[logs[left][0]] == 0:
                        del active[logs[left][0]]
                left += 1
            right = max(left, right)
            while right < m and logs[right][1] <= q:
                if logs[right][0] not in active: active[logs[right][0]] = 0
                active[logs[right][0]] += 1
                right += 1
            tmp[q] = n - len(active)
        return [tmp[q] for q in queries]
