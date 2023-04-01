class Solution:
    def makeSubKSumEqual(self, arr: List[int], k: int) -> int:
        if k == 1:
            a = sorted(arr)
            median = a[len(a) // 2]
            return sum([abs(a[i] - median) for i in range(len(a))])
        total, n = 0, len(arr)
        visited = [False for i in range(n)]
        for i in range(n):
            if visited[i]: continue
            a = [arr[i]]
            j = (i + k) % n
            while j != i:
                visited[j] = True
                a.append(arr[j])
                j = (j + k) % n
            a = sorted(a)
            median = a[len(a) // 2]
            total += sum([abs(a[i] - median) for i in range(len(a))])
        return total