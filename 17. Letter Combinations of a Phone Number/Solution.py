class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        keys = {'2': ['a', 'b', 'c'], '3': ['d', 'e', 'f'], '4': ['g', 'h', 'i'], '5': ['j', 'k', 'l'], '6': ['m', 'n', 'o'], '7': ['p', 'q', 'r', 's'], '8': ['t', 'u', 'v'], '9': ['w', 'x', 'y', 'z']}
        if not digits: return []
        if len(digits) == 1: return keys[digits]
        res = []
        for k in keys[digits[0]]:
            for foll in self.letterCombinations(digits[1:]):
                res.append(k + foll)
        return res
