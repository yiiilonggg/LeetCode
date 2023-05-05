class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowels = set(['a', 'e', 'i', 'o', 'u'])
        count, res, n, left = 0, 0, len(s), 0
        for i in range(k):
            if s[i] in vowels: count += 1
        res = count
        for i in range(k, n):
            if s[left] in vowels: count -= 1
            if s[i] in vowels: count += 1
            left += 1
            res = max(res, count)
        return res