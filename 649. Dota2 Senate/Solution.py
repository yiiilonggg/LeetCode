class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        r, d, rban, dban = 0, 0, 0, 0
        q = []
        for c in senate:
            q.append(c)
            if c == 'R':
                r += 1
            else:
                d += 1
        while r and d:
            curr = q.pop(0)
            if curr == 'D':
                if dban > 0:
                    dban -= 1
                    d -= 1
                else:
                    rban += 1
                    q.append(curr)
            else:
                if rban > 0:
                    rban -= 1
                    r -= 1
                else:
                    dban += 1
                    q.append(curr)
        return "Radiant" if r else "Dire"