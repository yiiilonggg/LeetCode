class Solution:
    def isPalindrome(self, s: str) -> bool:
        left, right = 0, len(s) - 1
        s = list(s)
        while left < right:
            while left < right and not s[left].isalnum():
                left += 1
            while left < right and not s[right].isalnum():
                right -= 1
            if s[left].isupper():
                s[left] = chr(ord(s[left]) + 32)
            elif s[right].isupper():
                s[right] = chr(ord(s[right]) + 32)
            elif s[left] == s[right]:
                left += 1
                right -= 1
            else:
                return False
        return True
