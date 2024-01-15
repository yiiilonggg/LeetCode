class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        wins, loses = [0 for i in range(100001)], [0 for i in range(100001)]
        for m in matches:
            wins[m[0]] += 1
            loses[m[1]] += 1
        zeros, ones = [], []
        for i in range(100001):
            if wins[i] != 0 and loses[i] == 0:
                zeros.append(i)
            elif loses[i] == 1:
                ones.append(i)
        return [zeros, ones]
