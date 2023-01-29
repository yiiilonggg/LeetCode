class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        n, res = len(weights), 0
        separators = sorted([weights[i] + weights[i + 1] for i in range(n - 1)])
        return sum(separators[n - k:]) - sum(separators[:k - 1])