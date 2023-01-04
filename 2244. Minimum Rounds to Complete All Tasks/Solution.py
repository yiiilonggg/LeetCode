class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        counter = Counter(tasks)
        rounds = 0
        for v in counter.values():
            if v == 1: return -1
            rounds += (v + 2) // 3
        return rounds
