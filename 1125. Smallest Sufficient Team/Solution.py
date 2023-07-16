class Solution:
    def smallestSufficientTeam(self, req_skills: List[str], people: List[List[str]]) -> List[int]:
        n, m = len(req_skills), len(people)
        skill = dict([s, i] for i, s in enumerate(req_skills))
        pmask = [0 for i in range(len(people))]
        dp = dict([[i, []] for i in range(1 << n)])
        for i, p in enumerate(people):
            for s in p:
                pmask[i] |= (1 << skill[s])
        for i, p in enumerate(people):
            for prev, team in dp.items():
                if prev != 0 and not team: continue
                curr = prev | pmask[i]
                if curr == prev: continue
                if not dp[curr] or len(dp[curr]) > len(team) + 1:
                    dp[curr] = team + [i]
        return dp[(1 << n) - 1]
