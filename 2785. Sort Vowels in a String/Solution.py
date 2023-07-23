class Solution:
    def sortVowels(self, s: str) -> str:
        vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        vs = []
        for c in s:
            if c in vowels: vs.append(c)
        vs.sort(key = lambda x: ord(x))
        i = 0
        res = []
        for c in s:
            if c not in vowels:
                res.append(c)
            else:
                res.append(vs[i])
                i += 1
        return "".join(res)
