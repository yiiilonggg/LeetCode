class Solution:
    def countPalindromePaths(self, parent: List[int], s: str) -> int:
        n, res = len(parent), 0
        graph = [[] for i in range(n)]
        for i, p in enumerate(parent):
            if p == -1: continue
            graph[p].append(i)
        masks = dict()
        q = [[0, 0]]
        while q:
            l = len(q)
            for i in range(l):
                curr, cmask = q.pop(0)
                if cmask in masks: res += masks[cmask]
                masks[cmask] = 1 if cmask not in masks else masks[cmask] + 1
                for j in range(26):
                    nmask = cmask ^ (1 << j)
                    if nmask in masks: res += masks[nmask]
                for neighbour in graph[curr]:
                    nmask = cmask ^ (1 << (ord(s[neighbour]) - ord('a')))
                    q.append([neighbour, nmask])
        return res
