class Solution:
    def isValid(self, s: str) -> bool:
        stack, b = [], dict([['(', ')'], ['[', ']'], ['{', '}']])
        for c in s:
            if c in b:
                stack.append(c)
            else:
                if not stack: return False
                if b[stack[-1]] != c: return False
                stack.pop()
        return not stack