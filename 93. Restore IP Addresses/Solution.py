class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        self.res = []
        self.strs = ["", "", "", ""]
        self.n = len(s)
        self.backtrack(s, 0, 0)
        return self.res
        
    def backtrack(self, s, curr, pointer):
        if curr == self.n:
            if pointer < 3: return
            for s in self.strs:
                if len(s) == 0: return
                if s[0] == '0' and len(s) > 1: return
            self.res.append('.'.join(self.strs))
            return
        self.strs[pointer] += s[curr]
        if int(self.strs[pointer]) <= 255:
            self.backtrack(s, curr + 1, pointer)
            if pointer < 3: self.backtrack(s, curr + 1, pointer + 1)
        self.strs[pointer] = self.strs[pointer][:-1]