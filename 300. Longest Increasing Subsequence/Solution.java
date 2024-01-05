class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] s=new int[nums.length];
        int t=0;
        for(int n:nums){
            int l=0,r=t;
            while(l<r){
                int m=(l+r)/2;
                if(s[m]<n){
                    l=m+1;
                }else{
                    r=m;
                }
            }
            s[l]=n;
            if(l==t)t++;
        }
        return t;
    }
}
