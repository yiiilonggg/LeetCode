class Solution {
public:
    int countTriplets(vector<int>& arr) {
        int n=arr.size(),r=0,a;
        for(int i=0;i<n;i++){
            a=arr[i];
            for(int k=i+1;k<n;k++){
                a^=arr[k];
                if(a==0)r+=k-i;
            }
        }
        return r;
    }
};
