class Solution:
    def maximumNumberOfStringPairs(self, words: List[str]) -> int:
        count, n = 0, len(words)
        for i in range(n):
            rev = words[i][::-1]
            for j in range(i + 1, n):
                if rev == words[j]:
                    count += 1
                    break
        return count
