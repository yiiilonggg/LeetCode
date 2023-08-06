class Solution:
    def finalString(self, s: str) -> str:
        f = ""
        for c in s:
            if c == 'i':
                f = f[::-1]
            else:
                f += c
        return f
