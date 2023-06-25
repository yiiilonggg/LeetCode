class Solution:
    def survivedRobotsHealths(self, positions: List[int], healths: List[int], directions: str) -> List[int]:
        n = len(positions)
        comb = sorted([[positions[i], healths[i], directions[i]] for i in range(n)], key = itemgetter(0))
        res = dict()
        i = 0
        while i < n and comb[i][2] == 'L':
            res[comb[i][0]] = comb[i][1]
            i += 1
        stack = []
        while i < n:
            if comb[i][2] == 'R':
                stack.append(comb[i])
            else:
                flag = False
                while stack:
                    if stack[-1][1] == comb[i][1]:
                        stack.pop()
                        flag = True
                        break
                    elif stack[-1][1] < comb[i][1]:
                        comb[i][1] -= 1
                        stack.pop()
                    else:
                        stack[-1][1] -= 1
                        break
                if not stack and not flag:
                    res[comb[i][0]] = comb[i][1]
            i += 1
        for s in stack:
            res[s[0]] = s[1]
        return [res[p] for p in positions if p in res]
