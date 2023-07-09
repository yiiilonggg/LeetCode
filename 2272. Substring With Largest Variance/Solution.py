class Solution:
    def largestVariance(self, s: str) -> int:
        high = 0
        ch = 'abcdefghijklmnopqrstuvwxyz'
        for i in range(26):
            for j in range(i + 1, 26):
                a, b = ch[i], ch[j]
                curr = 0
                currHigh, currLow = 0, 0
                prevHigh, prevLow = 0, 0
                hasA, hasB = False, False
                for c in s:
                    if c == a:
                        hasA = True
                        curr += 1
                        currHigh = max(prevHigh, currHigh)
                        prevHigh = curr
                    elif c == b:
                        hasB = True
                        curr -= 1
                        currLow = min(prevLow, currLow)
                        prevLow = curr
                    if hasA and hasB:
                        high = max(high, curr - currLow, currHigh - curr)
        return high
