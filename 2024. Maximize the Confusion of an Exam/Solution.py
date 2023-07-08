class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        n, left, high, ts, fs, count = len(answerKey), 0, 0, 0, 0, 0
        for right in range(n):
            if answerKey[right] == 'T':
                ts += 1
            else:
                fs += 1
            count = min(ts, fs)
            while count > k:
                if answerKey[left] == 'T':
                    ts -= 1
                else:
                    fs -= 1
                count = min(ts, fs)
                left += 1
            high = max(high, right - left + 1)
        return high
