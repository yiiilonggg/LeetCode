class Solution:
    def minMaxDifference(self, num: int) -> int:
        s = str(num)
        c, ch = s[0], '9'
        for cs in s:
            if cs != '9':
                ch = cs
                break
        high, low = "", ""
        for cs in s:
            if cs == c:
                low += "0"
            else:
                low += cs
            if cs == ch:
                high += "9"
            else:
                high += cs
        return int(high) - int(low)