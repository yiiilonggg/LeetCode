class Solution:
    def buddyStrings(self, s: str, goal: str) -> bool:
        if len(s) != len(goal): return False
        first, firstC, second, secondC = ' ', ' ', ' ', ' '
        l = len(s)
        for x, y in zip(s, goal):
            if x == y: continue
            if first == ' ':
                first, firstC = x, y
            elif second == ' ':
                second, secondC = x, y
            else:
                return False
        if first == ' ': return len(set(s)) < len(s)
        if second == ' ': return False
        return first == secondC and firstC == second
