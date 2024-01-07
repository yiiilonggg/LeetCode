class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        t=0
        m=[dict() for i in range(len(nums))]
        for i in range(1,len(nums)):
            for j in range(i):
                d=nums[i]-nums[j]
                t+=m[j][d] if d in m[j] else 0
                m[i][d]=(0 if d not in m[i] else m[i][d])+(0 if d not in m[j] else m[j][d])+1
        return t
