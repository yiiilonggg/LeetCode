class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        int n=arr.size();
        vector<int>ls(n,0),rs(n,0),s;
        for(int i=0;i<n;i++){
            while(!s.empty()&&arr[s.back()]>=arr[i])s.pop_back();
            ls[i]=(s.empty())?0:s.back()+1;
            s.push_back(i);
        }
        s.clear();
        for(int i=n-1;i>=0;i--){
            while(!s.empty()&&arr[s.back()]>arr[i])s.pop_back();
            rs[i]=(s.empty())?n-1:s.back()-1;
            s.push_back(i);
        }
        long long r=0,mod=1000000007;
        for(int i=0;i<n;i++){
            r=(r+((i-ls[i])*(rs[i]-i)+(i-ls[i])+(rs[i]-i)+1ll)*arr[i])%mod;
        }
        return r;
    }
};
