class Solution:
    def smallestString(self, s: str) -> str:
        change, l, i = False, len(s), 0
        ch = [c for c in s]
        while i < l and ch[i] == 'a': i += 1
        if i == l: return s[:-1] + 'z'
        while i < l and ch[i] != 'a':
            ch[i] = chr(ord(ch[i]) - 1)
            i += 1
        return ''.join(ch)
