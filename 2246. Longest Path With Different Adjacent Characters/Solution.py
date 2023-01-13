class Solution:
    def longestPath(self, parent: List[int], s: str) -> int:
        n, res = len(parent), 1
        inDegree, paths = [0 for i in range(n)], [1 for i in range(n)]
        for i in range(1, n):
            inDegree[parent[i]] += 1
        q = [i for i in range(1, n) if inDegree[i] == 0]
        while q:
            curr = q.pop(0)
            currParent = parent[curr]
            inDegree[currParent] -= 1
            if currParent != 0 and inDegree[currParent] == 0: q.append(currParent)
            if s[curr] == s[currParent]: continue
            res = max(res, paths[curr] + paths[currParent])
            paths[currParent] = max(paths[currParent], paths[curr] + 1)
        return res