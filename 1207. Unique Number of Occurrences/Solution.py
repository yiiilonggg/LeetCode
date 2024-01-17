class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        seen = Counter(arr)
        return len(set(seen.values())) == len(seen.keys())
