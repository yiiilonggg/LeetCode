class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        s=[0 for i in range(len(nums))]
        t=0
        for n in nums:
            l,r=0,t
            while l<r:
                m=(l+r)//2
                if s[m]<n:
                    l=m+1
                else:
                    r=m
            s[l]=n
            if l==t:t+=1
        return t
