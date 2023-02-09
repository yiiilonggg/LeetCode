class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        res = 0
        suffixes = [set() for i in range(26)]
        for idea in ideas:
            suffixes[self.getIdx(idea)].add(idea[1:])
        same = [[0 for i in range(26)] for j in range(26)]
        for i in range(26):
            for s in suffixes[i]:
                for j in range(i + 1, 26):
                    if s in suffixes[j]: same[i][j] += 1
        for i in range(26):
            for j in range(i + 1, 26):
                res += (len(suffixes[i]) - same[i][j]) * (len(suffixes[j]) - same[i][j]) * 2
        return res

    def getIdx(self, idea):
        return ord(idea[0]) - ord('a')