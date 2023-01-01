class Solution:
    def countDigits(self, num: int) -> int:
        copy, count = num, 0
        while copy > 0:
            curr = copy % 10
            if num % curr == 0: count += 1
            copy //= 10
        return count
