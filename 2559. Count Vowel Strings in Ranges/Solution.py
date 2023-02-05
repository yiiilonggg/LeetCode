class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        vowels = set(['a', 'e', 'i', 'o', 'u'])
        n, m = len(words), len(queries)
        prefix = [0 for i in range(n + 1)]
        for i in range(n):
            prefix[i + 1] = prefix[i] + 1 if words[i][0] in vowels and words[i][-1] in vowels else prefix[i]
        res = []
        for x, y in queries:
            res.append(prefix[y + 1] - prefix[x])
        return res