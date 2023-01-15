class Solution:
    def differenceOfSum(self, nums: List[int]) -> int:
        elementSum, digitSum = 0, 0
        for n in nums:
            elementSum += n
            while n > 0:
                digitSum += n % 10
                n //= 10
        return abs(elementSum - digitSum)